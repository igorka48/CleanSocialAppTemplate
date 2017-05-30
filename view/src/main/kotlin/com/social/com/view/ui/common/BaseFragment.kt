/**
 * Copyright (C) 2014 android10.org. All rights reserved.

 * @author Fernando Cejas (the android10 coder)
 */
package com.social.com.view.ui.common

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.social.com.AndroidApplication
import com.social.com.di.HasComponent
import com.social.com.di.components.ApplicationComponent
import com.social.com.di.components.DaggerFragmentComponent
import com.social.com.di.components.FragmentComponent
import com.social.com.di.modules.FragmentModule

/**
 * Base [android.app.Fragment] class for every fragment in this application.
 */
abstract class BaseFragment : MvpAppCompatFragment() {

    var component: FragmentComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()
    }

    private fun initializeInjector() {
        component = DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .fragmentModule(getFragmentModule())
                .build()
    }

    protected fun getFragmentModule(): FragmentModule {
        return FragmentModule(this)
    }



    /**
     * Shows a [android.widget.Toast] message.

     * @param message An string representing a message to be shown.
     */
    protected fun showToastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    protected fun <C> getComponent(componentType: Class<C>): C {
        return componentType.cast((activity as HasComponent<*>).component)
    }

    protected fun getApplicationComponent(): ApplicationComponent {
        return (context.applicationContext as AndroidApplication).applicationComponent
    }



}
