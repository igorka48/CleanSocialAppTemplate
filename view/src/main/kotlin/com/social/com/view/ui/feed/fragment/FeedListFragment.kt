package com.social.com.view.ui.feed.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.social.com.view.ui.feed.view.FeedListView
import com.social.com.view.ui.feed.presenter.FeedListPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.social.com.domain.interactor.tutorial.GetAllPosts
import com.social.com.domain.interactor.feed.GetFeed
import com.social.com.domain.model.Feed
import com.social.com.view.ui.R
import com.social.com.view.ui.common.BaseFragment
import com.social.com.view.ui.feed.adapters.FeedAdapter
import kotlinx.android.synthetic.main.fragment_posts_list.*
import javax.inject.Inject

class FeedListFragment : BaseFragment(), FeedListView {
    @Inject
    lateinit var adapter: FeedAdapter

    @Inject
    lateinit var feed: GetFeed

    companion object {
        const val TAG = "FeedListFragment"

        fun newInstance(): FeedListFragment {
            val fragment: FeedListFragment = FeedListFragment()
            val args: Bundle = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var presenter: FeedListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        component?.inject(this)
        return inflater.inflate(R.layout.fragment_feed_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.feed = feed
        presenter.initData()
    }

    fun initViews() {
        recyclerView.adapter = adapter
    }

    override fun showData(data: List<Feed>) {
        adapter.data = data
    }

}
