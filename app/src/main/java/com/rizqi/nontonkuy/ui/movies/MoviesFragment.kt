package com.rizqi.nontonkuy.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.di.ViewModelFactory
import com.rizqi.nontonkuy.viewmodel.MainViewModel
import com.rizqi.nontonkuy.vo.Status
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment() {

    private var adapter: MovieListAdapter = MovieListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        setupRecyclerView()

        activity?.let {
            viewModel.getMovies().observe(it, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progressBar.visibility = View.GONE
                            adapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

    }

    private fun setupRecyclerView() {
        rv_movie_list.layoutManager = LinearLayoutManager(activity)
        rv_movie_list.adapter = adapter
        rv_movie_list.setHasFixedSize(true)

    }
}