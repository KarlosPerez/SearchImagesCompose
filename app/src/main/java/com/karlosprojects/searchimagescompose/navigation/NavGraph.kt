package com.karlosprojects.searchimagescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.karlosprojects.searchimagescompose.screens.detail.DetailScreen
import com.karlosprojects.searchimagescompose.screens.home.HomeScreen
import com.karlosprojects.searchimagescompose.screens.search.SearchScreen
import com.karlosprojects.searchimagescompose.util.Constants.PHOTO_DETAILS_ARGUMENT_KEY
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(PHOTO_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(PHOTO_DETAILS_ARGUMENT_KEY)
                ?.let { DetailScreen(it, navController) }
        }
    }
}