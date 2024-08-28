package com.example.photos.photos_features.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.photos.photos_features.utils.Constants.PHOTOS_TABLE
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable

@Entity(tableName = PHOTOS_TABLE)
data class Photo(
    @PrimaryKey(autoGenerate = false)
    @Embedded
    val id:String,
    val urls:PhotosUrls,
    val color:String,
    @Contextual
    val user:PhotosCreator,
    val description:String?,
    val alternateDescription:String?
)