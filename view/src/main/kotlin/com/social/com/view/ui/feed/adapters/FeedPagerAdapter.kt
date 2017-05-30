package com.social.com.view.ui.socials

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.social.com.view.ui.feed.fragment.FeedListFragment

class FeedPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

   // private val all: socialsListFragment = socialsListFragment()


    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        when (position) {
//            0 -> return socialsListFragment()
//            1 -> return all
//            2 -> return all
//            3 -> return all
//        }
        return FeedListFragment()
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Recent"
            1 -> return "All"
            2 -> return "Near"
            3 -> return "Map"
        }
        return null
    }

}