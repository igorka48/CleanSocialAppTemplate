package com.social.com.domain.repository

import com.social.com.domain.model.TutorialPage
import io.reactivex.Observable

/**
 * Created by igor on 3/16/17.
 */
interface TutorialRepository {

    fun pages(): Observable<List<TutorialPage>>


}
