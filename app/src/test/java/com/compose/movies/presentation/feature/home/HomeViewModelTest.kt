import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.compose.movies.data.remote.NetworkResult
import com.compose.movies.domain.usecase.GetPopularMoviesUseCase
import com.compose.movies.mockedApiKey
import com.compose.movies.movieUIList
import com.compose.movies.presentation.feature.home.HomeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    private lateinit var viewModel: HomeViewModel
    private lateinit var useCase: GetPopularMoviesUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        useCase = mockk(relaxed = true)
        viewModel = HomeViewModel(useCase)
    }

    @Test
    fun `getMovieList should update movies when API call is successful`() = testScope.runTest {
        // Arrange
        val apiKey = mockedApiKey
        val movies = movieUIList
        coEvery { useCase.getPopularMovies(apiKey) } returns flowOf(NetworkResult.Success(movies))

        // Act
        viewModel.getMovieList(apiKey)

        // Assert
        advanceTimeBy(100)

        assertEquals(movies, viewModel.movies.value)
        assertEquals(false, viewModel.isLoading.value)
        assertNull(viewModel.error.value)
    }

    @Test
    fun `getMovieList should update error when API call fails`() = testScope.runTest {
        // Arrange
        val apiKey = mockedApiKey
        val errorMessage = "An unexpected error has occurred. Please try again later."
        coEvery { useCase.getPopularMovies(apiKey) } returns flowOf(NetworkResult.Error(errorMessage))

        // Act
        viewModel.getMovieList(apiKey)

        // Assert
        advanceTimeBy(100)

        assertTrue(viewModel.movies.value.isEmpty())
        assertEquals(false, viewModel.isLoading.value)
        assertEquals(errorMessage, viewModel.error.value)
    }

    @Test
    fun `getMovieList should update loading state when API call is in progress`() = testScope.runTest {
        // Arrange
        val apiKey = mockedApiKey
        coEvery { useCase.getPopularMovies(apiKey) } returns flowOf(NetworkResult.Loading())

        // Act
        viewModel.getMovieList(apiKey)

        // Assert
        advanceTimeBy(100)

        assertTrue(viewModel.movies.value.isEmpty())
        assertEquals(true, viewModel.isLoading.value)
        assertNull(viewModel.error.value)
    }

}
