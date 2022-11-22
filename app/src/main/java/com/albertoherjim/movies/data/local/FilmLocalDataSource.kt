package com.albertoherjim.movies.data.local

import com.albertoherjim.movies.domain.Film

interface FilmLocalDataSource {

    fun saveFilm(filmId: String, film: Film)
    fun getFilm(filmId: String): Film?
    fun getFilms(): List<Film>
}