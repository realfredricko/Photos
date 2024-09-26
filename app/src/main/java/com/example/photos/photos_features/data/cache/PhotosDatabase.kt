package com.example.photos.photos_features.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.photos.photos_features.data.cache.photosdaos.PhotosDao
import com.example.photos.photos_features.data.cache.photosdaos.PhotosRemoteKeysDao
import com.example.photos.photos_features.data.model.Photo
import com.example.photos.photos_features.data.model.PhotosRemoteKeys
import com.example.photos.photos_features.utils.Converters

//Data entities represent tables in the app database
//Database class provides the app with instances of the DAOs.
//The app uses the DAOs to retrieve data from the database
// as instances of the associated data entity
@Database(entities = [Photo::class,PhotosRemoteKeys::class], version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class PhotosDatabase:RoomDatabase() {
    abstract fun photosDao():PhotosDao
    abstract fun photosRemoteKeysDao():PhotosRemoteKeysDao
}