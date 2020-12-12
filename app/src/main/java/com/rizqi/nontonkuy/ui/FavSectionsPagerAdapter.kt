@file:Suppress("PrivatePropertyName")

package com.rizqi.nontonkuy.ui

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rizqi.nontonkuy.ui.movies.MoviesFragment
import com.rizqi.nontonkuy.ui.tvs.TvShowFragment

class FavSectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val TAB_TITLES = arrayOf("Movies", "TV Show")

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MoviesFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }
    @Nullable
    override fun getPageTitle(position: Int): CharSequence {
        return TAB_TITLES[position]
    }
    override fun getCount(): Int {
        return 2
    }
}