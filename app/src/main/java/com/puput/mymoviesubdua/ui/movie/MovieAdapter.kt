package com.puput.mymoviesubdua.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puput.mymoviesubdua.data.entity.ListMovieResponse
import com.puput.mymoviesubdua.databinding.ListItemMovieBinding


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val listMovie = ArrayList<ListMovieResponse>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        private const val IMAGE_URL = "https://image.tmdb.org/t/p/w200"
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ListMovieResponse)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setDataMovie(movie: List<ListMovieResponse>?) {
        if (movie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    inner class MovieViewHolder(private val binding: ListItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: ListMovieResponse) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(IMAGE_URL + movie.posterPath)
                    .apply(RequestOptions().override(200, 250))
                    .into(imgItemPhoto)

                titleMovie.text = movie.title
                score.text = movie.voteAverage.toString()

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(movie)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding =
            ListItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size
}