package com.social.com.view.ui.signup

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.social.com.domain.interactor.DefaultObserver
import com.social.com.domain.interactor.tutorial.DoLogin
import com.social.com.domain.model.LoginResponse

@InjectViewState
class SignupPresenter : MvpPresenter<SignupView>() {
    var login: DoLogin? = null

    public fun signIn(phone: String) {
        login?.execute(SignObserver(), null)
    }

    inner class SignObserver: DefaultObserver<LoginResponse>() {
        override fun onNext(t: LoginResponse) {
            super.onNext(t)
            viewState.successSignIn()
        }

        override fun onComplete() {
            super.onComplete()
        }

        override fun onError(exception: Throwable) {
            super.onError(exception)
        }

    }
}
