package com.albertoherjim.movies.data.remote

data class FilmApiModel(
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: Float,
    val year: String,
    val poster: String
)
