package com.hamed.articlesviewer.screens.home

import com.hamed.core.model.Article
import com.hamed.navigation.base.BasePresenter
import com.hamed.navigation.base.BaseView

interface Main {

    interface MainPresenter : BasePresenter<MainView> {
        fun getArticlesList()
        fun dateIncrement()
        fun dateDecrement()
    }

    interface MainView : BaseView {
        fun updateList(articles: List<Article>)
        fun updateDate(date: String)
        fun displayDateIncrement(visible:Boolean)
        fun displayDateDecrement(visible:Boolean)
    }
}