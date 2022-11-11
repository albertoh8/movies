package com.albertoherjim.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.albertoherjim.movies.data.ApiClient

class MainActivity : AppCompatActivity() {

    val apiClient = ApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun getFilmById(filmId:String){
        val film = apiClient.getFilm(filmId)
        Log.d("@dev", "Film: $film")
    }
    fun getFilms(){
        val films = apiClient.getFilms()
        Log.d("@dev", "Film: $films")
    }
}