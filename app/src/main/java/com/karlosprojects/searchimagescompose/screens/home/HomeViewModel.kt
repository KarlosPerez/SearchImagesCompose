package com.karlosprojects.searchimagescompose.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.karlosprojects.searchimagescompose.domain.IUnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: IUnsplashRepository
): ViewModel() {
    val getAllImages = repository.getAllImages()
}