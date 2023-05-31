package com.compose.movies.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.movies.presentation.feature.detail.MovieDetail
import com.compose.movies.presentation.feature.home.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(route = Screens.DetailScreen.route,
            arguments = listOf(
                navArgument(MOVIE_TITLE) {
                    type = NavType.StringType
                    nullable = false
                },
                navArgument(MOVIE_SYNOPSIS) {
                    type = NavType.StringType
                    nullable = false
                }
            )) {
            MovieDetail(
                title = it.arguments?.getString("title") ?: "",
                synopsis = it.arguments?.getString("synopsis") ?: ""
            )
        }
    }
}