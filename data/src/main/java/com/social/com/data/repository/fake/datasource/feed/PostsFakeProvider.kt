package com.social.com.data.repository.fake.datasource.tutorial

import com.social.com.domain.model.Post
import javax.inject.Inject

/**
 * Created by igor on 3/17/17.
 */
class PostsFakeProvider @Inject
internal constructor() {
    fun getsocialsData(): List<Post> {
        val list = ArrayList<Post>()
        (1..10).mapTo(list) {
            Post("Post " + it)
        }
        return list
    }
}