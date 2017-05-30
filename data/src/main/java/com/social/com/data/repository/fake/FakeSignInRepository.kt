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
package com.social.com.data.repository.fake.datasource

import com.social.com.domain.model.LoginResponse


class FakeSignInRepository @javax.inject.Inject
internal constructor() : com.social.com.domain.repository.LoginRepository {
    init {
        android.util.Log.d("DAGGER TEST", "" + this::class.java.name)
    }
    override fun login(): io.reactivex.Observable<LoginResponse> {
       return io.reactivex.Observable.just(com.social.com.domain.model.LoginResponse("OK"))
    }
}
