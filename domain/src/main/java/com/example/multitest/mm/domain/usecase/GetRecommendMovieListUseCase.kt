package com.example.multitest.mm.domain.usecase

import com.example.multitest.mm.domain.repository.MovieRepository
import javax.inject.Inject

class GetRecommendMovieListUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke(movieId : Int) =
        movieRepository.getRecommendMovies(movieId)
}