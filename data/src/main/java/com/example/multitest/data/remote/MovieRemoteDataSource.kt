package com.example.multitest.data.remote

import com.example.multitest.data.model.MovieEntity
import com.example.multitest.data.model.SummaryActorEntity
import com.example.multitest.data.model.SummaryMovieEntity


interface MovieRemoteDataSource {

    suspend fun getSummaryMovies(): List<SummaryMovieEntity>

    suspend fun getMovie(movieId: Int): MovieEntity

    suspend fun getActors(movieId: Int): List<SummaryActorEntity>

    suspend fun getRecommendMovies(movieId: Int): List<SummaryMovieEntity>

    suspend fun getSimilarMovies(movieId: Int): List<SummaryMovieEntity>
}