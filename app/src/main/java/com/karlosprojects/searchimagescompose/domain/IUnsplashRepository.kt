package com.karlosprojects.searchimagescompose.domain

import androidx.paging.PagingData
import com.karlosprojects.searchimagescompose.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface IUnsplashRepository {

    fun getAllImages(): Flow<PagingData<UnsplashImage>>

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>>

}