package com.albertoherjim.movies.data.local.db

import com.albertoherjim.movies.domain.Film

fun FilmEntity.toDomain(): Film {
    return Film(
        this.filmId,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster
    )
}

fun Film.toEntity(filmId:String): FilmEntity{
    return FilmEntity(
        this.id,
        this.title,
        this.plot,
        this.genre,
        this.rating,
        this.year,
        this.poster
    )
}