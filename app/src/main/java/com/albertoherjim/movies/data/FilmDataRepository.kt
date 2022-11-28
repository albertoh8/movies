package com.albertoherjim.movies.data

import com.albertoherjim.movies.data.local.FilmLocalDataSource
import com.albertoherjim.movies.data.remote.FilmRemoteDataSource
import com.albertoherjim.movies.domain.Film
import com.albertoherjim.movies.domain.FilmRepository

class FilmDataRepository(
    val localSource: FilmLocalDataSource,
    val remoteSource: FilmRemoteDataSource
) : FilmRepository {

    override fun getFilm(filmId: String): Film? {
        var film = localSource.getFilm(filmId)
        if (film == null){
            film = remoteSource.getFilm(filmId)
        }
        return film
    }

    override fun getFilms(): List<Film> {
        var films = localSource.getFilms()
        if (films.isEmpty()) {
            films = remoteSource.getFilms()
            if (films.isNotEmpty()) {
                localSource.save(films)
            }
        }
        return films
    }
}