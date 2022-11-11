package com.albertoherjim.movies.data

import com.albertoherjim.movies.data.remote.Api.FilmApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val baseEndPoints: String = "https://movies-and-shows-api.cyclic.app"
    private val apiService: ApiService

    init {
        apiService = buildApiEndPoints()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .baseUrl(baseEndPoints)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    fun buildApiEndPoints() = createRetrofitClient().create(ApiService::class.java)

    fun getFilms(): List<FilmApiModel>{
        val callFilm = apiService.getFilms()
        val response = callFilm.execute()
        return if (response.isSuccessful) {
            val film = response.body()
            film ?: emptyList()
        } else{
            emptyList()
        }
    }
    fun getFilm(filmId:String): FilmApiModel? {
        val film = apiService.getFilm(filmId)
        val response = film.execute()
        return if (response.isSuccessful) {
            response.body()
        }else  {
            null
        }

    }
}