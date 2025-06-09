package com.example.multitest.di

import android.app.Application
import com.example.multitest.MMApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
internal object AppComponent {

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(application: Application) : String =
        (application as MMApplication).baseUrl
}