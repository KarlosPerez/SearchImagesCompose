package com.karlosprojects.searchimagescompose.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karlosprojects.searchimagescompose.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM unsplash_image_table")
    fun getAllImages(): PagingSource<Int, UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImage>)

    @Query("SELECT * FROM unsplash_image_table WHERE id = :id")
    fun getPhotoDetail(id: String): Flow<UnsplashImage>

    @Query("DELETE FROM unsplash_image_table")
    suspend fun deleteAllImages()
}