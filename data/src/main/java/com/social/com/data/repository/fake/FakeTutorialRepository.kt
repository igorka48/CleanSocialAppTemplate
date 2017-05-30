package com.social.com.data.repository.fake.datasource

import android.util.Log
import com.social.com.data.repository.fake.datasource.tutorial.TutorialFakeProvider
import com.social.com.domain.model.TutorialPage
import com.social.com.domain.repository.TutorialRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * [TutorialRepository] for retrieving user data.
 */
class FakeTutorialRepository @Inject
internal constructor(val tutorialDataRepository: TutorialFakeProvider) : TutorialRepository {
    init {
        Log.d("DAGGER TEST", "" + this::class.java.name)
    }
    override fun pages(): Observable<List<TutorialPage>> {
        return Observable.just(tutorialDataRepository.getTutorialData())
    }
}
