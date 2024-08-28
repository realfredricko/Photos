package com.example.photos.photos_features.data.cache.photosdaos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.photos.photos_features.data.model.Photo

//Provides methods for the app to query,insert....
@Dao
interface PhotosDao {
    @Query("SELECT * FROM photos_table")
    fun getAllPhotos():PagingSource<Int,Photo>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPhotos(photos: List<Photo>)
    @Query("DELETE FROM photos_table")
    suspend fun clearAllPhotos()

}