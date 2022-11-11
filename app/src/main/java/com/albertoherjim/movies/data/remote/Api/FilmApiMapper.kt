package com.albertoherjim.movies.data.remote

import com.albertoherjim.movies.data.remote.Api.FilmApiModel
import com.albertoherjim.movies.domain.Film

fun FilmApiModel.toDomain(): Film {
    return Film(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster
    )
}