package com.social.com.view.ui.socials.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.social.com.view.ui.R
import com.social.com.view.ui.common.BaseFragment
import com.social.com.view.ui.socials.adapters.PostsPagerAdapter
import com.social.com.view.ui.socials.presenter.PostsContainerPresenter
import com.social.com.view.ui.socials.view.PostsContainerView
import kotlinx.android.synthetic.main.fragment_post_container.*
import javax.inject.Inject

class PostsContainerFragment : BaseFragment(), PostsContainerView {
    companion object {
        const val TAG = "socialsContainerFragment"
    }

   @Inject
   lateinit var pagerAdapter: PostsPagerAdapter

    @InjectPresenter
    lateinit var mpostsContainerPresenter: PostsContainerPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        component?.inject(this)
        return inflater.inflate(R.layout.fragment_post_container, container, false)
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
