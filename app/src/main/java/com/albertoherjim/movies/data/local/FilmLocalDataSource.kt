package com.albertoherjim.movies.data.local

import com.albertoherjim.movies.domain.Film

interface FilmLocalDataSource {
    fun saveFilm(film: Film)
    fun getFilm(filmId: String): Film?
    fun getFilms(): List<Film>
    fun save(films: List<Film>)
}