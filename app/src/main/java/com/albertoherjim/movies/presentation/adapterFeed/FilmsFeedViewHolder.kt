package com.albertoherjim.movies.presentation.adapterFeed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.albertoherjim.extensions.loadUrl
import com.albertoherjim.movies.databinding.ViewItemFilmFeedBinding
import com.albertoherjim.movies.domain.GetFilmUseCase
import com.albertoherjim.movies.presentation.FilmsDetailActivity

class FilmsFeedViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(film : GetFilmUseCase.FilmFeed) {
        val binding = ViewItemFilmFeedBinding.bind(view)
        binding.image.loadUrl(film.poster)
        binding.title.text = film.title
        binding.genre.text = film.genre
        binding.rating.text = film.rating
        view.setOnClickListener {
            view.context.startActivity(
                FilmsDetailActivity.getIntent(
                    view.context, film.poster
                )
            )
        }

    }
}