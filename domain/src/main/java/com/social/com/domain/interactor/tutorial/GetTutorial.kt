package com.social.com.domain.interactor.tutorial

import com.social.com.domain.executor.PostExecutionThread
import com.social.com.domain.executor.ThreadExecutor
import com.social.com.domain.interactor.UseCase
import com.social.com.domain.model.TutorialPage
import com.social.com.domain.repository.TutorialRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by igor on 3/16/17.
 */
/**
 * This class is an implementation of [UseCase] that represents a use case for
 * retrieving a collection of all [TutorialPage].
 */
class GetTutorial @Inject
internal constructor(val userRepository: TutorialRepository, threadExecutor: ThreadExecutor,
                     postExecutionThread: PostExecutionThread) : UseCase<List<TutorialPage>, Void>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(params: Void?): Observable<List<TutorialPage>> {
        return this.userRepository.pages()
    }
}
