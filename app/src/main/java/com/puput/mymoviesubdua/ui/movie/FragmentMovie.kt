package com.puput.mymoviesubdua.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.puput.mymoviesubdua.data.entity.ListMovieResponse
import com.puput.mymoviesubdua.databinding.FragmentMovieBinding
import com.puput.mymoviesubdua.ui.detail.DetailMovieActivity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FragmentMovie : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    private val viewModel: MovieViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val movieAdapter = MovieAdapter()
            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovie().observe(viewLifecycleOwner) {
                movieAdapter.setDataMovie(it)
                with(fragmentMovieBinding.rvMovie) {
                    layoutManager = GridLayoutManager(context, 2)
                    setHasFixedSize(true)
                    adapter = movieAdapter
                    movieAdapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
                        override fun onItemClicked(data: ListMovieResponse) {
                            val intent = Intent(context, DetailMovieActivity::class.java)
                            intent.putExtra(DetailMovieActivity.EXTRA_DATA, data.id.toString())
                            intent.putExtra("status", DetailMovieActivity.EXTRA_MOVIE)
                            startActivity(intent)
                        }

                    })
                }
                fragmentMovieBinding.progressBar.visibility = View.INVISIBLE
            }

        }
    }


}