package com.karlosprojects.searchimagescompose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.karlosprojects.searchimagescompose.data.local.UnsplashDatabase
import com.karlosprojects.searchimagescompose.data.paging.SearchPagingSource
import com.karlosprojects.searchimagescompose.data.paging.UnsplashRemoteMediator
import com.karlosprojects.searchimagescompose.data.remote.UnsplashApi
import com.karlosprojects.searchimagescompose.domain.IUnsplashRepository
import com.karlosprojects.searchimagescompose.model.UnsplashImage
import com.karlosprojects.searchimagescompose.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class UnsplashRepository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) : IUnsplashRepository {

    override fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = {
            unsplashDatabase.unsplashImageDao().getAllImages()
        }
        return Pager(
            config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(
                    unsplashApi = unsplashApi,
                    query = query
                )
            }
        ).flow
    }

    override fun getPhotoDetail(photoId: String): Flow<UnsplashImage> {
       return unsplashDatabase.unsplashImageDao().getPhotoDetail(photoId)
    }

}