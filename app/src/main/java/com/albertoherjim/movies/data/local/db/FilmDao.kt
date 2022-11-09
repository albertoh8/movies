package com.albertoherjim.movies.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveFilm(film: FilmEntity): Long

    @Query("SELECT * FROM $TABLE_NAME WHERE filmId = :filmId")
    fun getFilm(filmId: String): FilmEntity?
}