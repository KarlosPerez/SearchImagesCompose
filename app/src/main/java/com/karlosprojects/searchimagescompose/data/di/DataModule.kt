package com.karlosprojects.searchimagescompose.data.di

import androidx.paging.ExperimentalPagingApi
import com.karlosprojects.searchimagescompose.data.local.UnsplashDatabase
import com.karlosprojects.searchimagescompose.data.remote.UnsplashApi
import com.karlosprojects.searchimagescompose.data.repository.UnsplashRepository
import com.karlosprojects.searchimagescompose.domain.IUnsplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@ExperimentalPagingApi
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providesUnsplashRepository(
        unsplashApi: UnsplashApi,
        unsplashDatabase: UnsplashDatabase
    ): IUnsplashRepository {
        return UnsplashRepository(unsplashApi, unsplashDatabase)
    }
}