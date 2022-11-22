package com.albertoherjim.movies.presentation.adapterFeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.albertoherjim.movies.R
import com.albertoherjim.movies.domain.GetFilmUseCase

class FilmsFeedAdapter : RecyclerView.Adapter<FilmsFeedViewHolder>() {

    private val dataItems = mutableListOf<GetFilmUseCase.FilmFeed>()

    fun setDataItems(films: List<GetFilmUseCase.FilmFeed>){
        dataItems.clear()
        dataItems.addAll(films)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsFeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_film_feed, parent, false)
        return FilmsFeedViewHolder(view)

    }

    override fun onBindViewHolder(holder: FilmsFeedViewHolder, position: Int) {
        holder.bind(dataItems[position] )
    }

    override fun getItemCount(): Int = dataItems.size
}