package com.social.com.view.ui.socials.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.social.com.domain.interactor.tutorial.GetAllPosts
import com.social.com.domain.model.Post
import com.social.com.view.ui.R
import com.social.com.view.ui.common.BaseFragment
import com.social.com.view.ui.socials.adapters.PostsAdapter
import com.social.com.view.ui.socials.presenter.PostsListPresenter
import com.social.com.view.ui.socials.view.PostsListView
import kotlinx.android.synthetic.main.fragment_posts_list.*
import javax.inject.Inject

class PostsListFragment : BaseFragment(), PostsListView {

    @Inject lateinit var posts: GetAllPosts

    companion object {
        const val TAG = "PostsListFragment"
    }
    @Inject
    lateinit var adapter: PostsAdapter

    @InjectPresenter
    lateinit var presenter: PostsListPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        component?.inject(this)
        return inflater.inflate(R.layout.fragment_posts_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.posts = posts
        presenter.initData()
    }

    fun initViews(){
        recyclerView.adapter = adapter
    }
    override fun showData(data: List<Post>){
        adapter.data = data
    }

}
