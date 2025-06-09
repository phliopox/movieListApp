package com.example.multitest.remote.impl

import kotlinx.coroutines.async
import com.example.multitest.components.Device
import com.example.multitest.data.model.MovieEntity
import com.example.multitest.data.model.SummaryActorEntity
import com.example.multitest.data.model.SummaryMovieEntity
import com.example.multitest.data.remote.MovieRemoteDataSource
import com.example.multitest.remote.Constant.YOUTUBE_PREFIX_URL
import com.example.multitest.remote.api.ApiService
import com.example.multitest.remote.model.filterActor
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val device: Device
) : MovieRemoteDataSource {
    override suspend fun getSummaryMovies(): List<SummaryMovieEntity> = apiService.getSummaryMovies(
        device.language,
        device.country
    ).summaryMovies.map { it.toData() }


    override suspend fun getMovie(movieId: Int): MovieEntity = coroutineScope {
        val movieDeferred = async { apiService.getMovie(movieId, device.language) }
        val videoUrlDeferred = async { getVideoUrl(movieId) }

        val movie = movieDeferred.await()
        val videoUrl = videoUrlDeferred.await()

        with(movie) {
            MovieEntity(
                id,
                name,
                description,
                posterImageUrl,
                backdropImageUrl,
                videoUrl,
                rating,
                rateCount,
                releasedAt,
                runtime,
                genres.map { it.toData() }

            )
        }
    }

    private suspend fun getVideoUrl(movieId: Int): String {
        val videos = apiService.getVideos(movieId, device.language).results
        return videos.filter {
            it.site == YOUTUBE && it.type == TRAILER
        }.map { YOUTUBE_PREFIX_URL + it.key }.firstOrNull() ?: ""
    }

    override suspend fun getActors(movieId: Int): List<SummaryActorEntity> =
        apiService.getActors(movieId, device.language).cast.filterActor().map { it.toData() }


    override suspend fun getRecommendMovies(movieId: Int): List<SummaryMovieEntity> =
        apiService.getRecommendMovies(movieId, device.language).summaryMovies.map { it.toData() }


    override suspend fun getSimilarMovies(movieId: Int): List<SummaryMovieEntity> =
        apiService.getSimilarMovies(movieId, device.language).summaryMovies.map { it.toData() }


    companion object {
        const val YOUTUBE = "YouTube"
        private const val TRAILER = "Trailer"
    }
}