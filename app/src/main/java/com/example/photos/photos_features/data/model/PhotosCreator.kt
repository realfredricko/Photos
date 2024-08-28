package com.example.photos.photos_features.data.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class PhotosCreator(
    @SerializedName("links")
    val name:String,
    val username:String,
    @Embedded
    @Contextual
    val userLinks:PhotosCreatorLinks
)
