package com.hamed.articlesviewer.screens.home.presenter

import com.hamed.articlesviewer.screens.home.view.MainView
import com.hamed.navigation.base.BasePresenter

interface HomePresenter : BasePresenter<MainView> {
    fun getArticlesList()
}