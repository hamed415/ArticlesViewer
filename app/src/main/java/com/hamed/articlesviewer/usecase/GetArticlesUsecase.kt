package com.hamed.articlesviewer.usecase

import com.hamed.articlesviewer.BuildConfig
import com.hamed.articlesviewer.mapper.toArticles
import com.hamed.core.model.Article
import com.hamed.core.usecase.SingleUseCaseImpl
import com.hamed.repository.repository.NewsRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetArticlesUsecase : SingleUseCaseImpl<List<Article>, GetArticlesUsecase.params>(),
    KoinComponent {
    private val repository: NewsRepository by inject()

    override fun getSingle(params: params): Single<List<Article>> {
        return repository.getArticles(
            params.q,
            params.from,
            params.sortBy,
            BuildConfig.API_NEWS_KEY
        )
            .flatMap {
                Single.just(it.toArticles())
            }
    }

    data class params(
        val q: String = "",
        val from: String = "",
        val sortBy: String = ""
    )

}