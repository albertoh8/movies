package com.albertoherjim.movies.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.albertoherjim.movies.databinding.ActivityFilmsFeedBinding
import com.albertoherjim.movies.domain.GetFilmUseCase
import com.albertoherjim.movies.presentation.adapterFeed.FilmsFeedAdapter


class FilmsFeedActivity : AppCompatActivity() {

    private var binding: ActivityFilmsFeedBinding? = null
    private val filmsFeedAdapter = FilmsFeedAdapter()

    private val viewModel by lazy {
        FilmsFactory().getFilmsViewModel(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        setupObservers()
        viewModel.loadFilms()
    }

    private fun setupBinding() {
        binding = ActivityFilmsFeedBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupView(){
        binding?.apply {
            listFilms.adapter = filmsFeedAdapter
            listFilms.layoutManager =
                LinearLayoutManager(
                    this@FilmsFeedActivity,
                    LinearLayoutManager.VERTICAL,
                    false
            )
        }
    }

    private fun setupObservers(){
        val filmFeedSubscriber =
            Observer<List<GetFilmUseCase.FilmFeed>> { filmFeed ->
                filmsFeedAdapter.setDataItems(filmFeed)
            }
        viewModel.filmFeedPublisher.observe(this, filmFeedSubscriber)
    }

}