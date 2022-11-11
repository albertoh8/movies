package com.albertoherjim.movies.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


const val TABLE_NAME = "film"

@Entity(tableName = TABLE_NAME)
data class FilmEntity(
    @PrimaryKey val filmId: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "plot") val plot: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "rating") val rating: String,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "poster") val poster: String
    )