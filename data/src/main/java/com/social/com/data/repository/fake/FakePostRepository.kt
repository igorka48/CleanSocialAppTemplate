package com.social.com.data.repository.fake.datasource

import com.social.com.data.repository.fake.datasource.tutorial.PostsFakeProvider
import com.social.com.domain.model.Post
import com.social.com.domain.repository.PostsRepository
import com.social.com.domain.repository.TutorialRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * [TutorialRepository] for retrieving user data.
 */
class FakePostsRepository
@Inject internal constructor(val tutorialDataRepository: PostsFakeProvider) : PostsRepository {
    init {
        android.util.Log.d("DAGGER TEST", "" + this::class.java.name)
    }
    override fun allPosts(): Observable<List<Post>> {
        return Observable.just(tutorialDataRepository.getsocialsData())
    }
}
