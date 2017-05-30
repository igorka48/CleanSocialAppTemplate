package com.social.com.view.ui.tutorial

import com.arellomobile.mvp.MvpView
import com.social.com.domain.model.TutorialPage

interface PageView : MvpView {
  fun pageLoaded(page: TutorialPage?)
}
