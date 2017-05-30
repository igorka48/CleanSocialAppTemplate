package com.social.com.view.ui.tutorial

import com.arellomobile.mvp.MvpView
import com.social.com.domain.model.TutorialPage

interface TutorialView : MvpView {
    fun showTutorial(pages: List<TutorialPage>)
    fun tutorialStarted()
    fun tutorialCompleted()
    fun tutorialSkiped()
    fun pageForward()
    fun pageBackward()

}
