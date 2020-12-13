package com.rizqi.nontonkuy.ui

import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rizqi.nontonkuy.ui.movies.FavMoviesFragment
import com.rizqi.nontonkuy.ui.tvs.FavTvFragment

class FavSectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavMoviesFragment()
            1 -> fragment = FavTvFragment()
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

    companion object {
        private val TAB_TITLES = arrayOf("Movies", "TV Show")
    }
}