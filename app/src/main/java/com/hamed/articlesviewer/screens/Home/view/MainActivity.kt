package com.hamed.articlesviewer.screens.home.view

import android.os.Bundle
import com.hamed.articlesviewer.R
import com.hamed.articlesviewer.screens.home.presenter.HomePresenter
import com.hamed.articlesviewer.screens.home.presenter.HomePresenterImpl
import com.hamed.core.model.Articles
import com.hamed.navigation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<HomePresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.getArticlesList()
    }

    override fun updateList(articles: List<Articles>) {
        if(articles.size > 0)
        myText.text = articles[0].author
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter(): HomePresenter {
        return HomePresenterImpl()
    }
}