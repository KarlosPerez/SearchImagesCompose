package com.karlosprojects.searchimagescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.karlosprojects.searchimagescompose.navigation.NavGraph
import com.karlosprojects.searchimagescompose.ui.theme.SearchImagesComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchImagesComposeTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}