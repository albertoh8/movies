package com.albertoherjim.movies.domain

class GetFilmUseCase(
    val filmRepository: FilmRepository
) {

    fun execute(): List<FilmFeed> {
        val films = filmRepository.getFilms()

        val list = films.map { film ->
            FilmFeed(
                film.poster,
                film.title,
                film.plot,
                film.rating,
                film.year,
                film.genre
            )
        }
        return list
    }


    data class FilmFeed(
        val poster: String,
        val title: String,
        val plot: String,
        val rating: String,
        val year: String,
        val genre: String
    )
}