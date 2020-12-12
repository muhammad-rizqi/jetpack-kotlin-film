package com.rizqi.nontonkuy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rizqi.nontonkuy.ui.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
    view_pager.adapter = sectionsPagerAdapter
    tabs.setupWithViewPager(view_pager)
    supportActionBar?.elevation = 0f
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