package com.karlosprojects.searchimagescompose.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_Screen")
    object Search : Screen("search_screen")
    object Detail : Screen("detail_screen/{id}") {
        fun sendPhoto(id: String) = "detail_screen/$id"
    }
}