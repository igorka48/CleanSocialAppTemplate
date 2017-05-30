package com.social.com.data.repository.fake.datasource

import com.social.com.data.repository.fake.datasource.tutorial.PostsFakeProvider
import com.social.com.domain.model.Post
import com.social.com.domain.repository.PostsRepository
import com.social.com.domain.repository.TutorialRepository

/**
 * [TutorialRepository] for retrieving user data.
 */
class FakePostsRepository @javax.inject.Inject
internal constructor(val tutorialDataRepository: PostsFakeProvider) : PostsRepository {
    init {
        android.util.Log.d("DAGGER TEST", "" + this::class.java.name)
    }
    override fun allPosts(): io.reactivex.Observable<List<Post>> {
        return io.reactivex.Observable.just(tutorialDataRepository.getsocialsData())
    }
}
