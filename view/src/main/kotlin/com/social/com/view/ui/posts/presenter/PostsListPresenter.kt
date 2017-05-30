package com.social.com.view.ui.socials.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.social.com.domain.interactor.DefaultObserver
import com.social.com.domain.interactor.tutorial.GetAllPosts
import com.social.com.domain.model.Post
import com.social.com.view.ui.socials.view.PostsListView

@InjectViewState
class PostsListPresenter : MvpPresenter<PostsListView>() {

    lateinit var posts: GetAllPosts


    fun initData(){
        posts.execute(socialsObserver(), null)
    }

    fun showdata(pages: List<Post> ){
        viewState.showData(pages)
    }


    inner class socialsObserver: DefaultObserver<List<Post>>() {
        override fun onNext(t: List<Post>) {
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
