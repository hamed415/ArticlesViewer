package com.hamed.articlesviewer.screens.home

import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.model.Article
import io.reactivex.Single
import org.koin.core.KoinComponent

class MainInteractor : KoinComponent {
    private var getArticlesUsecase: GetArticlesUsecase = GetArticlesUsecase()

    fun getArticles(params: GetArticlesUsecase.params): Single<List<Article>> {
        return getArticlesUsecase.getSingle(params)
    }
}