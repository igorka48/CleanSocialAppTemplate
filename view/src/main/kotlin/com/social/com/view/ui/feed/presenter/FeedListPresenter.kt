package com.social.com.view.ui.feed.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.social.com.domain.interactor.DefaultObserver
import com.social.com.domain.interactor.feed.GetFeed
import com.social.com.domain.model.Feed
import com.social.com.view.ui.feed.view.FeedListView

@InjectViewState
class FeedListPresenter : MvpPresenter<FeedListView>() {
    lateinit var feed: GetFeed


    fun initData(){
        feed.execute(FeedObserver(), null)
    }

    fun showdata(data: List<Feed> ){
        viewState.showData(data)
    }


    inner class FeedObserver: DefaultObserver<List<Feed>>() {
        override fun onNext(t: List<Feed>) {
            super.onNext(t)
            showdata(t)
        }

        override fun onComplete() {
            super.onComplete()
        }

        override fun onError(exception: Throwable) {
            super.onError(exception)
        }

    }
}
