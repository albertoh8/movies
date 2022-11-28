package com.albertoherjim.movies.data.local.db

import com.albertoherjim.movies.data.local.FilmLocalDataSource
import com.albertoherjim.movies.domain.Film

class FilmsDbLocalDataSource(private val dao: FilmDao):FilmLocalDataSource {

    override fun saveFilm(film: Film){
        dao.saveFilm(film.toEntity())
    }

    override fun getFilm(filmId: String): Film? =
        dao.getFilm(filmId)?.toDomain()


    override fun getFilms(): List<Film> {
        return dao.getFilms().map {
            it.toDomain()
        }
    }

}