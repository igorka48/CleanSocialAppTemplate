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

import android.support.v4.app.Fragment
import com.social.com.di.PerFragment
import com.social.com.view.ui.feed.adapters.FeedAdapter
import com.social.com.view.ui.socials.FeedPagerAdapter
import com.social.com.view.ui.socials.adapters.PostsAdapter
import com.social.com.view.ui.socials.adapters.PostsPagerAdapter

import dagger.Module
import dagger.Provides


@Module
class FragmentModule(val fragment: Fragment) {
    
    @Provides
    @PerFragment
    internal fun fragment(): Fragment {
        return this.fragment
    }

    @Provides
    @PerFragment
    internal fun providePagesAdapter(): FeedPagerAdapter {
        return FeedPagerAdapter(fragment.childFragmentManager)
    }

    @Provides
    @PerFragment
    internal fun provideAdapter(): FeedAdapter {
        return FeedAdapter(fragment.context)
    }


    @Provides
    @PerFragment
    internal fun providesocialPagesAdapter(): PostsPagerAdapter {
        return PostsPagerAdapter(fragment.childFragmentManager)
    }

    @Provides
    @PerFragment
    internal fun providesocialsAdapter(): PostsAdapter {
        return PostsAdapter(fragment.context)
    }

}
