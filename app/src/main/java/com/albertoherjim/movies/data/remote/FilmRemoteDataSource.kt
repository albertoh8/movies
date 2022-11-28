package com.albertoherjim.movies.data.remote

import com.albertoherjim.movies.domain.Film

interface FilmRemoteDataSource {

    fun getFilm(filmId: String): Film?
    fun getFilms(): List<Film>
}