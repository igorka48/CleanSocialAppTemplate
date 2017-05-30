package com.social.com.view.ui.socials.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.social.com.view.ui.socials.fragments.PostsListFragment

class PostsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

   // private val all: socialsListFragment = socialsListFragment()


    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        when (position) {
//            0 -> return all
//        }
        return PostsListFragment()
    }

    override fun getCount(): Int {
        return 1
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "All posts"
        }
        return null
    }


}