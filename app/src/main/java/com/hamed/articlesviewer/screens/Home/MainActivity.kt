package com.hamed.articlesviewer.screens.home

import android.os.Bundle
import com.hamed.articlesviewer.R
import com.hamed.core.model.Articles
import com.hamed.navigation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<Main.MainPresenter>(),
    Main.MainView {

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

    override fun createPresenter(): Main.MainPresenter {
        return MainPresenter()
    }
}