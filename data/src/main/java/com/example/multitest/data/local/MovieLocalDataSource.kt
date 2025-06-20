package com.example.multitest.data.local

import com.example.multitest.data.model.MovieEntity

interface MovieLocalDataSource {
    suspend fun getMovie(movieId : Int) : MovieEntity?

    suspend fun saveMovie(movie: MovieEntity)
}