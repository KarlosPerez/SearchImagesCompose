package com.karlosprojects.searchimagescompose.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_Screen")
    object Search : Screen("search_screen")
}