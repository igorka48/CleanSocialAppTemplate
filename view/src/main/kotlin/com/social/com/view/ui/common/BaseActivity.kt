package com.social.com.view.ui.common

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.social.com.AndroidApplication
import com.social.com.di.HasComponent
import com.social.com.di.components.ActivityComponent
import com.social.com.di.components.ApplicationComponent
import com.social.com.di.components.DaggerActivityComponent
import com.social.com.di.modules.ActivityModule

abstract class BaseActivity : MvpAppCompatActivity() {

    var component: ActivityComponent? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this.getApplicationComponent().inject(this)
        initializeInjector()
        component?.inject(this)
    }

    /**
     * Get the Main Application component for dependency injection.
     */
    protected fun getApplicationComponent(): ApplicationComponent {
        return (application as AndroidApplication).applicationComponent
    }

    protected fun <C> getComponent(componentType: Class<C>): C {
        return componentType.cast((this as HasComponent<*>).component)
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }

    private fun initializeInjector() {
        component = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build()
    }
}
