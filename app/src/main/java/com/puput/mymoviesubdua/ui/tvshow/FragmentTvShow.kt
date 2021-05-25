package com.puput.mymoviesubdua.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse
import com.puput.mymoviesubdua.databinding.FragmentTvShowBinding
import com.puput.mymoviesubdua.ui.detail.DetailMovieActivity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FragmentTvShow : Fragment() {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    private val viewModel: TvShowViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)

        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val tvShowAdapter = TvShowAdapter()
            fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getAllTvShow().observe(viewLifecycleOwner) {
                tvShowAdapter.setDataTvShow(it)
                with(fragmentTvShowBinding.rvTvshow) {
                    layoutManager = GridLayoutManager(context, 2)
                    setHasFixedSize(true)
                    adapter = tvShowAdapter
                    tvShowAdapter.setOnItemClickCallback(object :
                        TvShowAdapter.OnItemClickCallbackTvShow {
                        override fun onItemClicked(data: ListTvShowResponse) {
                            val intent = Intent(context, DetailMovieActivity::class.java)
                            Log.d("series", data.id.toString())
                            intent.putExtra(DetailMovieActivity.EXTRA_DATA, data.id.toString())
                            intent.putExtra("status", DetailMovieActivity.EXTRA_TVSHOW)
                            startActivity(intent)
                        }
                    })
                }
                fragmentTvShowBinding.progressBar.visibility = View.GONE
            }

        }
    }
}