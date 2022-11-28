package com.albertoherjim.movies.data.remote.db

import com.albertoherjim.movies.data.local.db.FilmDao
import com.albertoherjim.movies.data.local.db.toDomain
import com.albertoherjim.movies.data.local.db.toEntity
import com.albertoherjim.movies.data.remote.FilmRemoteDataSource
import com.albertoherjim.movies.domain.Film

class FilmsDbRemoteDataSource(private val dao: FilmDao): FilmRemoteDataSource {


    override fun getFilms(): List<Film> {
        return dao.getFilms().map {
            it.toDomain()
        }
    }

    override fun getFilm(filmId: String): Film? {
        return  dao.getFilm(filmId)?.toDomain()
    }


}