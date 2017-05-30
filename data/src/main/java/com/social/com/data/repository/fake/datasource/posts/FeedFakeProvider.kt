package com.social.com.data.repository.fake.datasource.tutorial

import com.social.com.domain.model.Feed
import javax.inject.Inject

/**
 * Created by igor on 3/17/17.
 */
class FeedFakeProvider @Inject
internal constructor() {
    fun getFeedData(): List<Feed> {
        val list = ArrayList<Feed>()
        (1..20).mapTo(list) {
            Feed("Feed " + it)
        }
        return list
    }
}