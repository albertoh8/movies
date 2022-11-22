package com.albertoherjim.movies.presentation

import com.albertoherjim.movies.domain.GetFilmUseCase

interface  FilmCallback{
    fun onCall(filmFeed: List<GetFilmUseCase.FilmFeed>)
}