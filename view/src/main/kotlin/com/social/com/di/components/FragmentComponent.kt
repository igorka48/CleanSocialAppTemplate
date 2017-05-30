/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.social.com.di.components

import android.app.Activity
import android.support.v7.app.AppCompatActivity


import com.social.com.di.PerActivity
import com.social.com.di.PerFragment
import com.social.com.di.modules.ActivityModule
import com.social.com.di.modules.DataModule
import com.social.com.di.modules.FragmentModule
import com.social.com.view.ui.common.BaseFragment
import com.social.com.view.ui.feed.fragment.FeedContainerFragment
import com.social.com.view.ui.feed.fragment.FeedListFragment
import com.social.com.view.ui.socials.fragments.PostsContainerFragment
import com.social.com.view.ui.socials.fragments.PostsListFragment

import dagger.Component

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.

 * Subtypes of ActivityComponent should be decorated with annotation:
 * [com.social.com.di.PerActivity]
 */
@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class, DataModule::class)) interface FragmentComponent {
    //Exposed to sub-graphs.
    fun inject(fragment: PostsContainerFragment)
    fun inject(fragment: FeedContainerFragment)
    fun inject(fragment: PostsListFragment)
    fun inject(fragment: FeedListFragment)
    fun inject(fragment: BaseFragment)
}
