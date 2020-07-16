package com.hamed.articlesviewer.screens.home

import com.hamed.core.model.Article
import com.hamed.navigation.base.BasePresenter
import com.hamed.navigation.base.BaseView

interface Main {

    interface MainPresenter : BasePresenter<MainView> {
        fun getArticlesList()
    }

    interface MainView : BaseView {
        fun updateList(articles: List<Article>)
    }
}