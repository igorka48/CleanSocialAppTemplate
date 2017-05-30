package com.social.com.domain.interactor.feed

import com.social.com.domain.executor.PostExecutionThread
import com.social.com.domain.executor.ThreadExecutor
import com.social.com.domain.interactor.UseCase
import com.social.com.domain.model.Feed
import com.social.com.domain.model.TutorialPage
import com.social.com.domain.repository.FeedRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by igor on 3/16/17.
 */
/**
 * This class is an implementation of [UseCase] that represents a use case for
 * retrieving a collection of all [TutorialPage].
 */
class GetFeed @Inject
internal constructor(val feedRepository: FeedRepository, threadExecutor: ThreadExecutor,
                     postExecutionThread: PostExecutionThread) : UseCase<List<Feed>, Void>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(params: Void?): Observable<List<Feed>> {
        return this.feedRepository.feed()
    }
}
