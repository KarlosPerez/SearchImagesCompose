package com.karlosprojects.searchimagescompose.screens.detail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.karlosprojects.searchimagescompose.ui.theme.topAppBarContentColor
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoilApi
@InternalCoroutinesApi
@Composable
fun DetailScreen(
    photoId: String,
    navController: NavController,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    detailViewModel.getPhotoDetails(photoId = photoId)
    val photoDetail by detailViewModel.selectedPhoto.collectAsState()

    Scaffold(
        topBar = {
            MovieDetailsTopBar(navController)
        },
        contentColor = MaterialTheme.colors.topAppBarContentColor,
        backgroundColor = MaterialTheme.colors.topAppBarContentColor,
        content = {
            photoDetail?.let { PhotoDetailContent(it) }
        })
}