package com.hamed.articlesviewer.screens.home.interactor

import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.model.Articles
import io.reactivex.Single
import org.koin.core.KoinComponent

class HomeInteractor : KoinComponent {
    private var getArticlesUsecase: GetArticlesUsecase = GetArticlesUsecase()

    fun getArticles(params: GetArticlesUsecase.params): Single<List<Articles>> {
        return getArticlesUsecase.getSingle(params)
    }
}