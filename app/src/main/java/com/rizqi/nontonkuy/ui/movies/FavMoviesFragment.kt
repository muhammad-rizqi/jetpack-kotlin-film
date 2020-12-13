package com.rizqi.nontonkuy.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.di.ViewModelFactory
import com.rizqi.nontonkuy.viewmodel.BookmarkViewModel
import kotlinx.android.synthetic.main.fragment_fav_movies.*

class FavMoviesFragment : Fragment() {

  private lateinit var viewModel: BookmarkViewModel
  private var adapter: MovieListAdapter = MovieListAdapter()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_fav_movies, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupRecyclerView()

    val factory = ViewModelFactory.getInstance(requireActivity())
    viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]

    progressBar.visibility = View.VISIBLE
    activity?.let {
      viewModel.getMovieBookmarks().observe(it, {movie ->
        progressBar.visibility = View.GONE
        adapter.submitList(movie)
        adapter.notifyDataSetChanged()
      })
    }

  }

  private fun setupRecyclerView() {
    rv_movie_list.layoutManager = LinearLayoutManager(activity)
    rv_movie_list.adapter = adapter
    rv_movie_list.setHasFixedSize(true)

  }
}