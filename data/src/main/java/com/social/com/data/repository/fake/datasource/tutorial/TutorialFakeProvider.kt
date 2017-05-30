package com.social.com.data.repository.fake.datasource.tutorial

import com.social.com.domain.model.TutorialPage
import javax.inject.Inject

/**
 * Created by igor on 3/17/17.
 */
class TutorialFakeProvider @Inject
internal constructor() {
    fun getTutorialData(): List<TutorialPage> {
        val list = ArrayList<TutorialPage>()
        (1..4).mapTo(list) {
            TutorialPage("Page " + it)
        }
        return list
    }
}