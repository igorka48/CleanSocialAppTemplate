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

import com.social.com.data.repository.fake.FakeFeedRepository
import com.social.com.data.repository.fake.datasource.*
import com.social.com.domain.repository.*
import dagger.Module
import dagger.Provides

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
class DataModule {

    @Provides
    internal fun providePostsRepository(postsDataRepository: FakePostsRepository): PostsRepository {
        return postsDataRepository
    }


    @Provides
    internal fun provideFeedRepository(feedDataRepository: FakeFeedRepository): FeedRepository {
        return feedDataRepository
    }


    @Provides
    internal fun provideTutorialRepository(tutorialDataRepository: FakeTutorialRepository): TutorialRepository {
        return tutorialDataRepository
    }

    @Provides
    internal fun provideSignIn(loginRepository: FakeSignInRepository): LoginRepository {
        return loginRepository
    }

}
