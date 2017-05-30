package com.social.com.view.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.social.com.di.HasComponent
import com.social.com.di.components.ActivityComponent
import com.social.com.view.ui.R
import com.social.com.view.ui.common.BaseActivity
import com.social.com.view.ui.feed.fragment.FeedContainerFragment
import com.social.com.view.ui.socials.fragments.PostsContainerFragment
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView, HasComponent<ActivityComponent?> {


    //TODO: needs to create and destroy fragments on demand
    @Inject lateinit var feedFragment: FeedContainerFragment
    @Inject lateinit var socialsFragment: PostsContainerFragment


    companion object {
        const val TAG = "HomeActivity"
        fun getIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    @InjectPresenter
    lateinit var mHomePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getComponent(ActivityComponent::class.java).inject(this)
        setContentView(R.layout.activity_home)
        initViews()
        component?.inject(this)
    }



    fun initViews(){
        initBottomNavigation()
        showFeedScr()
    }

    fun initBottomNavigation(){
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_feed -> showFeedScr()
                R.id.action_search -> showSearchScr()
                R.id.action_social -> showsocialsScr()
                R.id.action_chats -> showChatsScr()
                R.id.action_profile -> showProfileScr()
            }
            true
        }
    }
    override fun showSearchScr() {
    }

    override fun showFeedScr() {
        replaceFragment(feedFragment)
    }

    override fun showProfileScr() {
    }

    override fun showChatsScr() {
    }

    override fun showsocialsScr() {
        replaceFragment(socialsFragment)
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentsContainer, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

}
