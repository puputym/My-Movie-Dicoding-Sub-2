package com.puput.mymoviesubdua.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse
import com.puput.mymoviesubdua.databinding.ListItemTvshowBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShow = ArrayList<ListTvShowResponse>()
    private lateinit var onItemClickCallbackTvShow: OnItemClickCallbackTvShow

    companion object {
        private const val IMAGE_URL = "https://image.tmdb.org/t/p/w200"
    }


    fun setDataTvShow(tvshow: List<ListTvShowResponse>?) {
        if (tvshow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvshow)
    }


    interface OnItemClickCallbackTvShow {
        fun onItemClicked(data: ListTvShowResponse)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallbackTvShow) {
        this.onItemClickCallbackTvShow = onItemClickCallback
    }


    inner class TvShowViewHolder(private val binding: ListItemTvshowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: ListTvShowResponse) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(IMAGE_URL + tvShow.posterPath)
                    .apply(RequestOptions().override(200, 250))
                    .into(imgItemPhoto)
                titleMovie.text = tvShow.name
                score.text = tvShow.voteAverage.toString()

                itemView.setOnClickListener {
                    onItemClickCallbackTvShow.onItemClicked(tvShow)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemTvShowBinding =
            ListItemTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size
}