package com.example.multitest.remote.api

import com.example.multitest.remote.model.CreditWrapperResponse
import com.example.multitest.remote.model.MovieResponse
import com.example.multitest.remote.model.SummaryMovieWrapperResponse
import com.example.multitest.remote.model.VideoWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie?@sort_by=popularity,desc")
    suspend fun getSummaryMovies(
        @Query("language") language: String,
        @Query("region") country: String,
    ): SummaryMovieWrapperResponse

    @GET("movie/{movieId}")
    suspend fun getMovie(
        @Path("movieId") movieId: Int,
        @Query("language") language: String
    ): MovieResponse

    @GET("movie/{movieId}/videos")
    suspend fun getVideos(
        @Path("movieId") movieId: Int,
        @Query("language") language: String
    ): VideoWrapperResponse

    @GET("movie/{movieId}/credits")
    suspend fun getActors(
        @Path("movieId") movieId: Int,
        @Query("language") language: String
    ): CreditWrapperResponse

    @GET("movie/{movieId}/recommendations")
    suspend fun getRecommendMovies(
        @Path("movieId") movieId: Int,
        @Query("language") language: String
    ): SummaryMovieWrapperResponse

    @GET("movie/{movieId}/similar")
    suspend fun getSimilarMovies(
        @Path("movieId") movieId: Int,
        @Query("language") language: String
    ) : SummaryMovieWrapperResponse
}