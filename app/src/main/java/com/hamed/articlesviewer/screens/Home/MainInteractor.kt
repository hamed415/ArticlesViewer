package com.hamed.articlesviewer.screens.home

import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.model.Article
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainInteractor : KoinComponent {
    private val getArticlesUsecase: GetArticlesUsecase by inject()

    fun getArticles(params: GetArticlesUsecase.Params): Single<List<Article>> {
        return getArticlesUsecase.getSingle(params)
    }
}