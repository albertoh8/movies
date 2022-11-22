package com.albertoherjim.movies.presentation

import android.content.Context
import androidx.room.Room
import com.albertoherjim.commons.data.local.db.AppDatabase
import com.albertoherjim.movies.data.RemoteApiClient
import com.albertoherjim.movies.data.FilmDataRepository
import com.albertoherjim.movies.data.local.db.FilmsDbLocalDataSource
import com.albertoherjim.movies.data.remote.Api.FilmApiRemoteDataSource
import com.albertoherjim.movies.domain.FilmRepository
import com.albertoherjim.movies.domain.GetFilmDetailUseCase
import com.albertoherjim.movies.domain.GetFilmUseCase



class FilmsFactory {

    fun getFilmsViewModel(applicationContext: Context) =
        FilmsFeedViewModel(getFilmUseCase(applicationContext))


    fun getFilmsDetailViewModel(applicationContext: Context): FilmDetailViewModel {
        return FilmDetailViewModel(
            getFilmDetailUseCase(applicationContext)
        )
    }

    fun getFilmUseCase(context: Context): GetFilmUseCase {
        return GetFilmUseCase(
            getFilmRepository(context)
        )
    }
    fun getFilmDetailUseCase(context: Context): GetFilmDetailUseCase {
        return GetFilmDetailUseCase(
            getFilmRepository(context)
        )
    }

    fun getFilmRepository(context: Context): FilmRepository {
        return FilmDataRepository(
            FilmsDbLocalDataSource(DataBaseSingleton.getInstance(context).filmsDao()),
            FilmApiRemoteDataSource(getApiClient())
        )
    }

    private fun getApiClient() = RemoteApiClient()


    object DataBaseSingleton {
        private var db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context, AppDatabase::class.java, "db-films"
                ).build()
            }
            return db!!
        }
    }
}