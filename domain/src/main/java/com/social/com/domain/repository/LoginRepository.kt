package com.social.com.domain.repository

import com.social.com.domain.model.LoginResponse
import io.reactivex.Observable


/**
 * Created by igor on 3/16/17.
 */
interface LoginRepository {

    fun login(): Observable<LoginResponse>


}
