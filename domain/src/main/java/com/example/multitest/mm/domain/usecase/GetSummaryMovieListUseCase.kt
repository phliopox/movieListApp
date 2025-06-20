package com.example.multitest.mm.domain.usecase

import com.example.multitest.mm.domain.repository.MovieRepository
import javax.inject.Inject

class GetSummaryMovieListUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke() =
        movieRepository.getSummaryMovies()
}