package com.albertoherjim.movies.data.local.mem

import com.albertoherjim.commons.data.MemDataStore
import com.albertoherjim.movies.data.local.FilmLocalDataSource
import com.albertoherjim.movies.domain.Film

class FilmsMemLocalDataSource(private val dataStore: MemDataStore<Film>):
    FilmLocalDataSource{

    override fun saveFilm(film: Film){
        dataStore.put(film.id, film)
    }
    override fun getFilm(filmId: String): Film?{
        return dataStore.get(filmId)
    }

    override fun getFilms(): List<Film> {
        val films = listOf<Film>()
        val movies:List<Film> = mutableListOf()
        for (film in films){
            movies.indexOf(dataStore.get(film.id))
        }
        return movies
    }
}