package com.albertoherjim.movies.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.albertoherjim.extensions.loadUrl
import com.albertoherjim.movies.databinding.ActivityFilmDetailBinding
import com.albertoherjim.movies.domain.GetFilmDetailUseCase

class FilmDetailActivity : AppCompatActivity() {

    private var binding: ActivityFilmDetailBinding? = null
    private var viewModel: FilmDetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        setupObserver()
        viewModel?.loadFilmDetails(getFilmId())
    }

    private fun setupBinding() {
        binding = ActivityFilmDetailBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupView() {


    }

    private fun setupObserver() {
        val filmDetailSubscriber = Observer<GetFilmDetailUseCase.FilmDetail> { filmDetail ->
              bind(filmDetail)
        }

        viewModel?.filmDetailPublisher?.observe(this, filmDetailSubscriber)
    }

    private fun bind(model: GetFilmDetailUseCase.FilmDetail){
        binding?.apply {
            image.loadUrl(model.poster)
            title.text = model.title
            plot.text = model.plot
            year.text = model.year
        }

    }

    private fun getFilmId (): String = intent.getStringExtra(KEY_FILM_ID).toString()


    companion object {
        private val KEY_FILM_ID = "key_film_id"

        fun getIntent(context: Context, superHeroId: String): Intent {
            val intent = Intent(context, FilmDetailActivity::class.java)
            intent.putExtra(KEY_FILM_ID, superHeroId)
            return intent
        }
    }
}

