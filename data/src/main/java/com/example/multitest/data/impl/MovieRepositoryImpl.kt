package com.example.multitest.data.impl

import com.example.multitest.data.safeFlowCall
import com.example.multitest.data.safeFlowCallWithCache
import com.example.multitest.data.local.MovieLocalDataSource
import com.example.multitest.data.remote.MovieRemoteDataSource
import com.example.multitest.data_resource.DataResource
import com.example.multitest.mm.domain.model.Movie
import com.example.multitest.mm.domain.model.SummaryActor
import com.example.multitest.mm.domain.model.SummaryMovie
import com.example.multitest.mm.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {
    override fun getSummaryMovies(): Flow<DataResource<List<SummaryMovie>>> = safeFlowCall(
        fetch = { movieRemoteDataSource.getSummaryMovies() },
    )

    override fun getMovie(movieId: Int): Flow<DataResource<Movie>> = safeFlowCallWithCache(
        localFetch = { movieLocalDataSource.getMovie(movieId) },
        remoteFetch = { movieRemoteDataSource.getMovie(movieId) },
        saveCache = { movieLocalDataSource.saveMovie(it) }
    )

    override fun getActors(movieId: Int): Flow<DataResource<List<SummaryActor>>> = safeFlowCall(
        fetch = { movieRemoteDataSource.getActors(movieId) }
    )

    override fun getRecommendMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>> =
        safeFlowCall(
            fetch = { movieRemoteDataSource.getRecommendMovies(movieId) }
        )

    override fun getSimilarMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>> =
        safeFlowCall(
            fetch = { movieRemoteDataSource.getSimilarMovies(movieId) }
        )
}