package com.example.photos

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//This class's used by dagger hilt library to generate the necessary
// codes to inject all the dependencies in the project
@HiltAndroidApp
class PhotosApplication : Application() {
}