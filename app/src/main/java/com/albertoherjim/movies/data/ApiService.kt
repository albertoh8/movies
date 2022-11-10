package com.albertoherjim.movies.data

import com.albertoherjim.movies.data.remote.Api.FilmApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface  ApiService {

    @GET("/movies")
    fun getFilms(): Call<List<FilmApiModel>>

    @GET("/movies/{filmId}")
    fun getFilm(@Path("filmId") filmId:String): Call<FilmApiModel>
}