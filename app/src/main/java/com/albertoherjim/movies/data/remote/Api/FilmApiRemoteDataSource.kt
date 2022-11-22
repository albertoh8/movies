package com.albertoherjim.movies.data.remote.Api

import com.albertoherjim.movies.data.RemoteApiClient
import com.albertoherjim.movies.data.remote.FilmRemoteDataSource
import com.albertoherjim.movies.data.remote.toDomain
import com.albertoherjim.movies.domain.Film

class FilmApiRemoteDataSource(val apiClient: RemoteApiClient): FilmRemoteDataSource {


    override fun getFilm(filmId: String): Film? =
         apiClient.getFilm(filmId)?.toDomain()


    override fun getFilms(): List<Film> {
        val films = apiClient.getFilms().map {
            it.toDomain()
        }
        return films
    }


}