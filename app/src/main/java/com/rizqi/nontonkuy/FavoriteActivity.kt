package com.rizqi.nontonkuy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rizqi.nontonkuy.ui.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_favorite.*


class FavoriteActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_favorite)


    val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
    fav_view_pager.adapter = sectionsPagerAdapter
    fav_tabs.setupWithViewPager(fav_view_pager)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.options_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.menu_favorite -> {
        val i = Intent(this, FavoriteActivity::class.java)
        startActivity(i)
        true
      }

      else -> true
    }
  }
}