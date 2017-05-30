package com.social.com.domain.repository

import com.social.com.domain.model.LoginResponse
import com.social.com.domain.model.Post
import io.reactivex.Observable


/**
 * Created by igor on 3/16/17.
 */
interface PostsRepository {

    fun allPosts(): Observable<List<Post>>


}
