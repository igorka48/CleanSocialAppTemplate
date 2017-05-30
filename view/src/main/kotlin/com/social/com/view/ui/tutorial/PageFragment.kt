package com.social.com.view.ui.tutorial

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.social.com.domain.model.TutorialPage
import com.social.com.view.ui.R
import kotlinx.android.synthetic.main.fragment_tutorial.*

class PageFragment : MvpAppCompatFragment(), PageView {


    companion object {
        const val TAG = "PageFragment"
        const val PAGE_OBJ = "page_obj"

        fun newInstance(page: TutorialPage?): PageFragment {
            val fragment: PageFragment = PageFragment()
            val args: Bundle = Bundle()
            fragment.arguments = args
            args.putParcelable(PAGE_OBJ, page)
            return fragment
        }
    }

    @InjectPresenter
    lateinit var presenter: PagePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tutorial, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.page = arguments.getParcelable<TutorialPage>(PAGE_OBJ)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun pageLoaded(page: TutorialPage?) {
        //TODO: Data binding?
        textView.text = page?.title ?: ""
    }
}
