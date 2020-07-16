package com.hamed.articlesviewer.screens.home.view

import com.hamed.core.model.Articles
import com.hamed.navigation.base.BaseView

interface MainView : BaseView {
    fun updateList(articles: List<Articles>)
}