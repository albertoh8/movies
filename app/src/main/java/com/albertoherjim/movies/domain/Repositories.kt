package com.albertoherjim.movies.domain

interface FilmRepository {
    fun getFilm(filmId:String): Film?
    fun getFilms(): List<Film>
}
