package com.rizqi.nontonkuy.ui.tvs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.data.model.Tv
import kotlinx.android.synthetic.main.activity_tv_detail.*

class TvDetailActivity : AppCompatActivity() {

  private lateinit var tv: Tv

  companion object {
    const val EXTRA_TV = "extra_tv"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_tv_detail)


    tv = intent.getParcelableExtra<Tv>(EXTRA_TV) as Tv


    bindToView()
  }


  @SuppressLint("SetTextI18n")
  private fun bindToView () {
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
}