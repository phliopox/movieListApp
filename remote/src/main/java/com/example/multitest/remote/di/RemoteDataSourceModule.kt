package com.example.multitest.remote.di

import com.example.multitest.data.remote.MovieRemoteDataSource
import com.example.multitest.remote.impl.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(source: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}