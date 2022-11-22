package com.albertoherjim.commons.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.albertoherjim.movies.data.local.db.FilmDao
import com.albertoherjim.movies.data.local.db.FilmEntity

@Database(entities = [FilmEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun filmsDao(): FilmDao
}