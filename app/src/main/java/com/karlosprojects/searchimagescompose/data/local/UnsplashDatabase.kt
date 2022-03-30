package com.karlosprojects.searchimagescompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karlosprojects.searchimagescompose.data.local.dao.UnsplashImageDao
import com.karlosprojects.searchimagescompose.data.local.dao.UnsplashRemoteKeysDao
import com.karlosprojects.searchimagescompose.model.UnsplashImage
import com.karlosprojects.searchimagescompose.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}