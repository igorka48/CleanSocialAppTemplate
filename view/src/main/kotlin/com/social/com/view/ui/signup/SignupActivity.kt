package com.social.com.view.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.view.RxView
import com.social.com.domain.interactor.tutorial.DoLogin
import com.social.com.view.ui.R
import com.social.com.view.ui.common.BaseActivity
import com.social.com.view.ui.tutorial.TutorialActivity
import kotlinx.android.synthetic.main.activity_signup.*
import javax.inject.Inject


class SignupActivity : BaseActivity(), SignupView {

    companion object {
        const val TAG = "SigninActivity"
        fun getIntent(context: Context): Intent = Intent(context, SignupActivity::class.java)
    }
    init {
        Log.d("DAGGER TEST", "FeedDataRepository")
    }
    @InjectPresenter
    lateinit var mSigninPresenter: SignupPresenter
    @Inject lateinit var login: DoLogin


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        RxView.clicks(signinButton)
                .subscribe { attemptLogin() }
        //signinButton.setOnClickListener {  }
        component?.inject(this)
        mSigninPresenter.login = login
    }

    private fun attemptLogin() {
        mSigninPresenter.signIn(phoneField.text.toString())
    }

    override fun finishSignIn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun failedSignIn(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideFormError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun successSignIn() {
        val intent = TutorialActivity.getIntent(this)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun startSignIn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun showFormError(message: String) {
        phoneField.error = message
    }

}

