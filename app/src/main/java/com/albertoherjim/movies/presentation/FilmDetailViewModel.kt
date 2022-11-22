package com.albertoherjim.movies.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertoherjim.movies.domain.GetFilmDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmDetailViewModel(private val getFilmDetailUseCase: GetFilmDetailUseCase) : ViewModel() {

    val filmDetailPublisher: MutableLiveData<GetFilmDetailUseCase.FilmDetail> by lazy {
        MutableLiveData<GetFilmDetailUseCase.FilmDetail>()
    }

    fun loadFilmDetails(filmId: String){
        viewModelScope.launch(Dispatchers.IO) {
            filmDetailPublisher.postValue(getFilmDetailUseCase.execute(filmId))
        }
    }
}