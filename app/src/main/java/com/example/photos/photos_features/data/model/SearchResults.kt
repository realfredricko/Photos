package com.example.photos.photos_features.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchResults(
    val results:List<Photo>
)