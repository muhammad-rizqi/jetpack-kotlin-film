package com.rizqi.nontonkuy.ui.tvs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.di.ViewModelFactory
import com.rizqi.nontonkuy.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

  private var adapter: TvListAdapter = TvListAdapter()

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_tv_show, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val factory = ViewModelFactory.getInstance(requireActivity())
    val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
    setupRecyclerView()

    activity?.let {
      viewModel.getTvs().observe(it) { tvs ->
        adapter.submitList(tvs.data)
        progressBar.visibility = View.GONE
      }
    }
  }

  private fun setupRecyclerView() {
    rv_tv_list.layoutManager = LinearLayoutManager(activity)
    rv_tv_list.adapter = adapter
    rv_tv_list.setHasFixedSize(true)

  }
}