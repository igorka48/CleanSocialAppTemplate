package com.social.com.view.ui.tutorial

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.social.com.domain.model.TutorialPage
import com.social.com.view.ui.tutorial.PageView

@InjectViewState
class PagePresenter : MvpPresenter<PageView>() {

    var page: TutorialPage? = null


    override fun attachView(view: PageView?) {
        super.attachView(view)
        viewState.pageLoaded(page)
    }




}
