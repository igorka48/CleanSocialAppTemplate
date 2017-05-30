package com.social.com.view.ui.feed.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.social.com.view.ui.feed.view.FeedContainerView
import com.social.com.view.ui.feed.presenter.FeedContainerPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.social.com.view.ui.R
import com.social.com.view.ui.common.BaseFragment
import com.social.com.view.ui.socials.FeedPagerAdapter
import kotlinx.android.synthetic.main.fragment_feed_container.*
import javax.inject.Inject

class FeedContainerFragment : BaseFragment(), FeedContainerView {
    companion object {
        const val TAG = "FeedContainerFragment"
    }
    @Inject
    lateinit var pagerAdapter: FeedPagerAdapter

    @InjectPresenter
    lateinit var mFeedContainerPresenter: FeedContainerPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        component?.inject(this)
        return inflater.inflate(R.layout.fragment_feed_container, container, false)
    }

    init {
        Log.d("DAGGER TEST", "FeedContainerFragment")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    fun initViews(){
        initPager()
        initTabs()
    }

    fun initTabs(){
        tabs.setupWithViewPager(viewPager)
    }

    fun initPager(){
        viewPager.adapter = pagerAdapter
    }
}
