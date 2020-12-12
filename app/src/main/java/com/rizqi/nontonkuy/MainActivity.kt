package com.rizqi.nontonkuy

import android.os.Bundle
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
}