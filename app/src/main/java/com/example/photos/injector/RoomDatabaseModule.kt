package com.example.photos.injector

import android.content.Context
import androidx.room.Room
import com.example.photos.photos_features.data.cache.PhotosDatabase
import com.example.photos.photos_features.utils.Constants.PHOTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//describes how to provide an instance to room database
@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    @Provides
    @Singleton
    fun createDatabase(
        @ApplicationContext context: Context
    ): PhotosDatabase {
        return Room.databaseBuilder(
            context,
            PhotosDatabase::class.java,
            PHOTO_DATABASE
        )
            .build()

    }
}
