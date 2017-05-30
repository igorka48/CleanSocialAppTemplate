package com.social.com.view.ui.feed.view

import com.arellomobile.mvp.MvpView
import com.social.com.domain.model.Feed

interface FeedListView : MvpView {
    fun showData(data: List<Feed>)
}
