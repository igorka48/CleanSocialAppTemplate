package com.social.com.view.ui.tutorial

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.social.com.domain.model.TutorialPage


class TutorialPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var pages: List<TutorialPage>? = null

    override fun getItem(position: Int): Fragment? {

        return PageFragment.newInstance(pages?.get(position))
    }

    override fun getCount(): Int {
        return pages?.size ?: 0
    }


    fun addAll(pages: List<TutorialPage>){
        this.pages = pages
        notifyDataSetChanged()
    }


}