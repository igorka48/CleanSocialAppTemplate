package com.social.com.view.ui.socials.view

import com.arellomobile.mvp.MvpView
import com.social.com.domain.model.Post

interface PostsListView : MvpView {
    fun showData(data: List<Post>)
}
