package com.rizqi.nontonkuy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rizqi.nontonkuy.ui.FavSectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_favorite.*


class FavoriteActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_favorite)

    val sectionsPagerAdapter = FavSectionsPagerAdapter(supportFragmentManager)
    fav_view_pager.adapter = sectionsPagerAdapter
    fav_tabs.setupWithViewPager(fav_view_pager)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.elevation = 0f
  }

}