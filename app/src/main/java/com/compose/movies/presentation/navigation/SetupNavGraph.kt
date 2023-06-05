package com.compose.movies.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.movies.presentation.feature.detail.MovieDetailRoute
import com.compose.movies.presentation.feature.home.HomeScreen
import com.compose.movies.presentation.navigation.Routes.DETAIL_ROUTE

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(
            route = DETAIL_ROUTE,
            arguments = listOf(
                navArgument(MOVIE_ID) {
                    type = NavType.IntType
                    nullable = false
                }
            )) {
            MovieDetailRoute(movieId = it.arguments?.getInt(MOVIE_ID) ?: -1)
        }
    }
}