package com.hamed.articlesviewer.screens.home

import com.hamed.core.model.Article
import com.hamed.core.base.BasePresenter
import com.hamed.core.base.BaseView

interface Main {

    interface MainPresenter : BasePresenter<MainView> {
        fun getArticlesList()
    }

    interface MainView : BaseView {
        fun updateList(articles: List<Article>)
    }
}