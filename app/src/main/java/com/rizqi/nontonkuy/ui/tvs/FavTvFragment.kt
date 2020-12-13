package com.rizqi.nontonkuy.ui.tvs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.di.ViewModelFactory
import com.rizqi.nontonkuy.viewmodel.BookmarkViewModel
import kotlinx.android.synthetic.main.fragment_fav_tv.*

class FavTvFragment : Fragment() {

  private lateinit var viewModel: BookmarkViewModel
  private var adapter = TvListAdapter()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_fav_tv, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    val factory = ViewModelFactory.getInstance(requireActivity())
    viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]

    progressBar.visibility = View.VISIBLE

    activity?.let {
      viewModel.getTvBookmarks().observe(it, {tv ->
        Log.d("DEBUUUG", tv.toString())
        progressBar.visibility = View.GONE
        adapter.submitList(tv)
        adapter.notifyDataSetChanged()
        setupRecyclerView()
      })
    }
  }

  private fun setupRecyclerView() {
    rv_tv_list.layoutManager = LinearLayoutManager(activity)
    rv_tv_list.adapter = adapter
    rv_tv_list.setHasFixedSize(true)

  }
}