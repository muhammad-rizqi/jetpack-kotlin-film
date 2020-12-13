package com.rizqi.nontonkuy.ui.tvs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.di.ViewModelFactory
import com.rizqi.nontonkuy.viewmodel.DetailTvViewModel
import com.rizqi.nontonkuy.vo.Status
import kotlinx.android.synthetic.main.activity_tv_detail.*

class TvDetailActivity : AppCompatActivity() {

  private lateinit var tv: Tv

  companion object {
    const val EXTRA_TV = "extra_tv"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tv_detail)
    val factory = ViewModelFactory.getInstance(this)
    val viewModel = ViewModelProvider(this, factory).get(DetailTvViewModel::class.java)

    tv = intent.getParcelableExtra<Tv>(EXTRA_TV) as Tv


    viewModel.setSelectedTv(tv.id)

    viewModel.tv.observe(this) {
      if (it != null) {
        when (it.status) {
          Status.LOADING -> tvProgressBar?.visibility = View.VISIBLE
          Status.SUCCESS -> if (it.data != null) {
            tvProgressBar?.visibility = View.GONE
            bindToView(it.data)
            val state = it.data.bookmarked
            setBookmarkState(state)
          }
          Status.ERROR -> {
            tvProgressBar?.visibility = View.GONE
            Toast.makeText(
              applicationContext,
              "Terjadi kesalahan",
              Toast.LENGTH_SHORT
            ).show()
          }
        }
      }
    }


    tvFloatingActionButton?.setOnClickListener {
      viewModel.setBookmark()
    }


  }


  @SuppressLint("SetTextI18n")
  private fun bindToView (tv: Tv) {
    tv_show_name.text = tv.name
    tv_first_air_date.text = tv.first_air_date
    tv_overview.text = tv.overview
    tv_vote_average.text = tv.vote_average.toString()
    tv_vote_count.text = " from " + tv.vote_count
    Glide.with(this)
      .load("https://image.tmdb.org/t/p/w500${tv.poster_path}")
      .into(tv_poster)
    title = tv.name
  }

  private fun setBookmarkState(state: Boolean) {
    if (state) {
      tvFloatingActionButton?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
    } else {
      tvFloatingActionButton?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
    }
  }
}