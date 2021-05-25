package com.puput.mymoviesubdua.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puput.mymoviesubdua.R
import com.puput.mymoviesubdua.databinding.ActivityDetailMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailMovieBinding
    private val viewModel: DetailMovieActivityViewModel by viewModel()

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w200"
        const val EXTRA_MOVIE = "movie"
        const val EXTRA_TVSHOW = "tvShow"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener(this)
        binding.share.setOnClickListener(this)

        val id = intent.getStringExtra(EXTRA_DATA)


        val status = intent.getStringExtra("status")
        if (status == EXTRA_MOVIE) {
            binding.apply {
                progressBar.visibility = View.VISIBLE
                viewModel.getDetailMovie(id.toString()).observe(this@DetailMovieActivity) {
                    title.text = it.title
                    year.text = it.releaseDate
                    durasi.text = it.runtime.toString()
                    score.text = it.voteAverage.toString()
                    tvDesc.text = it.overview

                    Glide.with(this@DetailMovieActivity)
                        .load(IMAGE_URL + it.posterPath)
                        .apply(RequestOptions().override(200, 250))
                        .into(imgItemPhoto)
                    progressBar.visibility = View.INVISIBLE

                }
            }
        } else {
            binding.apply {
                viewModel.getDetailTvShow(id.toString()).observe(this@DetailMovieActivity) {
                    title.text = it.name
                    year.text = it.firstAirDate
                    durasi.text = it.status
                    score.text = it.voteAverage.toString()
                    tvDesc.text = it.overview

                    Glide.with(this@DetailMovieActivity)
                        .load(IMAGE_URL + it.posterPath)
                        .apply(RequestOptions().override(200, 250))
                        .into(imgItemPhoto)

                }
            }
        }


    }

    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back -> {
                finish()
            }
            R.id.share -> {
                startActivity(Intent.createChooser(sendIntent, null))
            }
        }
    }
}