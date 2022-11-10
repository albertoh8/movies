package com.albertoherjim.movies.data.local

import com.albertoherjim.movies.domain.Film

interface FIlmLocalDataSource {
    fun saveFilm(film: Film)
    fun getFilm(filmId: String): Film?
    fun getFilms(): List<Film>
}