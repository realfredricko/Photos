package com.example.photos.photos_features.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.photos.photos_features.utils.Constants.PHOTO_REMOTE_TABLE

@Entity(tableName = PHOTO_REMOTE_TABLE
)
data class PhotosRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val prePage:Int?,
    val nextPage:Int?
)
