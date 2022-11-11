package com.albertoherjim.movies.data.local.xml

import android.content.SharedPreferences
import com.albertoherjim.movies.data.local.FIlmLocalDataSource
import com.albertoherjim.movies.domain.Film
import com.google.gson.Gson

class FilmXmlLocalDataSource(private val sharedPreferences: SharedPreferences) :
    FIlmLocalDataSource {
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    override fun saveFilm(film: Film) {
        val jsonNews = gson.toJson(film, Film::class.java)
        val edit = sharedPreferences.edit()
        edit.putString(film.id, jsonNews)
        edit.apply()
    }


    override fun getFilm(filmId: String): Film? {
        val jsonFilm = sharedPreferences.getString(filmId, null)
        return gson.fromJson(jsonFilm, Film::class.java)

    }

    override fun getFilms(): List<Film> {
        return sharedPreferences.all.map {
            gson.fromJson(it.value as String, Film::class.java)
        }
    }

    fun saveFilms(filmsList: MutableList<Film>) {
        filmsList.forEach { Film ->
            saveFilm(Film)
        }
    }

}