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
    val id:String,
    val description:String?,
    val alternateDescription:String?,
    val color:String,
    @Contextual
    @Embedded
    val user:PhotosCreator,
    val urls:PhotosUrls,
)