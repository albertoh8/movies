package com.albertoherjim.movies.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertoherjim.movies.domain.GetFilmUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FilmsFeedViewModel(private val getFilmsFeed: GetFilmUseCase): ViewModel() {

   val filmFeedPublisher: MutableLiveData<List<GetFilmUseCase.FilmFeed>> by lazy {
       MutableLiveData<List<GetFilmUseCase.FilmFeed>>()
   }

    fun loadFilms() {
        viewModelScope.launch(Dispatchers.IO) {
            val filmFeed = getFilmsFeed.execute()
            filmFeedPublisher.postValue(filmFeed)
        }
    }

}