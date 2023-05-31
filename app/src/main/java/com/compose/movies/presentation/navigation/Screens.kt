package com.compose.movies.presentation.navigation

import com.compose.movies.presentation.navigation.Routes.DETAIL_ROUTE
import com.compose.movies.presentation.navigation.Routes.HOME_ROUTE

sealed class Screens(val route: String) {
    object HomeScreen : Screens(HOME_ROUTE)
    object DetailScreen : Screens(DETAIL_ROUTE)
}
