package com.example.photos.photos_features.data.network

import com.example.photos.BuildConfig
import com.example.photos.photos_features.data.model.Photo
import com.example.photos.photos_features.data.model.SearchResults
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosAPI {
    @GET("/photos")
    suspend fun getAllPhotos(
        @Query("page:Int")page:Int,
        @Query("per_page:Int") perPage:Int = 10,
        @Query("api_key") apiKey:String = BuildConfig.API_KEY
    ):List<Photo>

    @GET("/search")
    suspend fun searchAllPhotos(
        @Query("query:String")query:String,
        @Query("per_page:Int") perPage:Int = 10,
        @Query("api_key") apiKey:String = BuildConfig.API_KEY
    ):SearchResults
}