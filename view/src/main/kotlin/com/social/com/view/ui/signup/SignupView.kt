package com.social.com.view.ui.signup

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SignupView : MvpView {
    fun startSignIn()

    fun finishSignIn()

    fun failedSignIn(message: String)

    fun hideError()

    fun hideFormError()

    fun showFormError(message: String)

    @StateStrategyType(SkipStrategy::class)
    fun successSignIn()
}
