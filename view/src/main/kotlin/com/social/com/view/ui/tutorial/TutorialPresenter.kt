package com.social.com.view.ui.tutorial

import android.support.v4.app.Fragment
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.social.com.domain.interactor.DefaultObserver
import com.social.com.domain.interactor.tutorial.GetTutorial
import com.social.com.domain.model.TutorialPage
import com.social.com.view.ui.tutorial.TutorialView
import javax.inject.Inject

@InjectViewState
class TutorialPresenter
internal constructor (): MvpPresenter<TutorialView>() {


    lateinit var tutorials: GetTutorial

    var currentPage = 0
    var pagesCount = 0


    companion object {
        const val TAG = "TutorialPresenter"
    }

    fun initData(){
        tutorials.execute(TutorialsObserver(), null)
    }

    fun showdata(pages: List<TutorialPage> ){
        viewState.showTutorial(pages)
    }

    fun pageChanged(page: Int){
        currentPage = page
        if(page == pagesCount-1){
            viewState.tutorialCompleted()
        }
    }

    inner class TutorialsObserver: DefaultObserver<List<TutorialPage>>() {
        override fun onNext(t: List<TutorialPage>) {
            super.onNext(t)
            currentPage = 0
            pagesCount = t.size
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
