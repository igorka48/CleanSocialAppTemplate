package com.social.com.view.ui.tutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.support.v4.view.RxViewPager
import com.social.com.domain.interactor.tutorial.GetTutorial
import com.social.com.domain.model.TutorialPage
import com.social.com.view.ui.R
import com.social.com.view.ui.common.BaseActivity
import com.social.com.view.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_tutorial.*
import javax.inject.Inject

class TutorialActivity : BaseActivity(), TutorialView {

    @Inject lateinit var adapter: TutorialPagerAdapter
    @Inject lateinit var tutorials: GetTutorial

    companion object {
        const val TAG = "TutorialActivity"
        fun getIntent(context: Context): Intent = Intent(context, TutorialActivity::class.java)
    }

    @InjectPresenter
    lateinit var mTutorialPresenter: TutorialPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component?.inject(this)
        setContentView(R.layout.activity_tutorial)
        initPager()
        mTutorialPresenter.tutorials = tutorials
        mTutorialPresenter.initData()

    }



    fun initPager(){
        pager.adapter = adapter

        /*
        * replace listener style code with rxbingings
         */
//        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
//            override fun onPageScrollStateChanged(state: Int) {
//              //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onPageSelected(position: Int) {
//               mTutorialPresenter.pageChanged(position)
//            }
//        })

        RxViewPager.pageSelections(pager).subscribe { page -> mTutorialPresenter.pageChanged(page)}


    }

    override fun showTutorial(pages: List<TutorialPage>) {
        adapter.addAll(pages)
    }

    override fun tutorialStarted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun tutorialCompleted() {
        gotoHome()
    }

    override fun tutorialSkiped() {
        gotoHome()
    }

    fun gotoHome(){
        val intent = HomeActivity.getIntent(this)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun pageBackward() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pageForward() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
