package com.example.multitest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MMApplication : Application() {
    val baseUrl : String
        get() = "https://api.themoviedb.org/3/"


}