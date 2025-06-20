package com.example.multitest.mm.domain.repository

import com.example.multitest.data_resource.DataResource
import com.example.multitest.mm.domain.model.Movie
import com.example.multitest.mm.domain.model.SummaryActor
import com.example.multitest.mm.domain.model.SummaryMovie
import kotlinx.coroutines.flow.Flow
import javax.xml.crypto.Data

interface MovieRepository {

    fun getSummaryMovies(): Flow<DataResource<List<SummaryMovie>>>

    fun getMovie(movieId: Int): Flow<DataResource<Movie>>

    fun getActors(movieId: Int): Flow<DataResource<List<SummaryActor>>>

    fun getRecommendMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>>

    fun getSimilarMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>>
}