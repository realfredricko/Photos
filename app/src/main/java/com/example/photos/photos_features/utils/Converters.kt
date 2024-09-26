package com.example.photos.photos_features.utils

    import androidx.room.TypeConverter
    import com.example.photos.photos_features.data.model.PhotosCreator
    import com.example.photos.photos_features.data.model.PhotosUrls
    import com.google.gson.Gson
    import com.google.gson.reflect.TypeToken

    object Converters {

        @TypeConverter
        fun fromPhotosCreator(photosCreator: PhotosCreator): String {
            return Gson().toJson(photosCreator)
        }

        @TypeConverter
        fun toPhotosCreator(json: String): PhotosCreator {
            val type = object : TypeToken<PhotosCreator>() {}.type
            return Gson().fromJson(json, type)
        }

        @TypeConverter
        fun fromPhotosUrls(photosUrls: PhotosUrls): String {
            return Gson().toJson(photosUrls)
        }

        @TypeConverter
        fun toPhotosUrls(json: String): PhotosUrls {
            val type = object : TypeToken<PhotosUrls>() {}.type
            return Gson().fromJson(json, type)
        }
    }
