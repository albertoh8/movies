package com.albertoherjim.movies.data.remote.Api

data class FilmApiModel(
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: String,
    val year: String,
    val poster: String
)
