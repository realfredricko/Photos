package com.example.photos.injector

import com.example.photos.photos_features.data.network.PhotosAPI
import com.example.photos.photos_features.utils.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//Define how to inject dependencies
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //Provide instance of Retrofit dependencies
    @Provides
    @Singleton
    fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15,TimeUnit.SECONDS)
            .connectTimeout(15,TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }
    @Provides
    @Singleton
    fun createUnsplashApi(retrofit: Retrofit):PhotosAPI{
        return retrofit.create(PhotosAPI::class.java)
    }
}