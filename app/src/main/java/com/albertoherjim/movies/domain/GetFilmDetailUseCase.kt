package com.albertoherjim.movies.domain

class GetFilmDetailUseCase(private val filmRepository: FilmRepository) {

    fun execute(filmId:String): FilmDetail {
        val film = filmRepository.getFilm(filmId)!!

        return FilmDetail(
            film.id,
            film.poster,
            film.title,
            film.plot,
            film.year
        )
    }
    data class FilmDetail(val id : String, val poster:String, val title:String, val plot: String , val year:String)
}
