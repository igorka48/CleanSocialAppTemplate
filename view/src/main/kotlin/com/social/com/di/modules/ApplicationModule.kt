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

import android.content.Context

import com.social.com.AndroidApplication
import com.social.com.UIThread
import com.social.com.data.executor.JobExecutor
import com.social.com.domain.executor.PostExecutionThread
import com.social.com.domain.executor.ThreadExecutor

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return this.application
    }

    @Provides
    @Singleton
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }



//    @Provides
//    @Singleton
//    internal fun provideLoginRepository(loginRepository: SignInRepositoryImp): LoginRepository {
//        return loginRepository
//    }


}
