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
package com.social.com.di.modules

import android.support.v7.app.AppCompatActivity
import com.social.com.di.PerActivity
import com.social.com.view.ui.feed.fragment.FeedContainerFragment
import com.social.com.view.ui.socials.fragments.PostsContainerFragment
import com.social.com.view.ui.tutorial.TutorialPagerAdapter
import dagger.Module
import dagger.Provides

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module(includes = arrayOf(DataModule::class))
class ActivityModule(val activity: AppCompatActivity) {

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    internal fun activity(): AppCompatActivity {
        return this.activity
    }

    @Provides
    @PerActivity
    internal fun provideFeedFragment(): FeedContainerFragment {
        return FeedContainerFragment()
    }

    @Provides
    @PerActivity
    internal fun providesocialsFragment(): PostsContainerFragment {
        return PostsContainerFragment()
    }

    @Provides
    @PerActivity
    internal fun provideFragmentPager(): TutorialPagerAdapter {
        return TutorialPagerAdapter(activity.supportFragmentManager)
    }





}
