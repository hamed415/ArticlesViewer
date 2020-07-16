package com.hamed.articlesviewer.usecase

import com.hamed.articlesviewer.mapper.toArticles
import com.hamed.core.model.Articles
import com.hamed.core.usecase.SingleUseCaseImpl
import com.hamed.repository.repository.NewsRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetArticlesUsecase : SingleUseCaseImpl<List<Articles>, GetArticlesUsecase.params>(),
    KoinComponent {
    private val repository: NewsRepository by inject()

    override fun getSingle(params: params?): Single<List<Articles>> {
        return repository.getArticles(
            params?.q ?: "",
            params?.from ?: "",
            params?.sortBy ?: "",
            params?.apiKey ?: ""
        )
            .flatMap { Single.just(it.toArticles()) }
    }

    data class params(
        val q: String = "",
        val from: String = "",
        val sortBy: String = "",
        val apiKey: String = "6cfe588c32024488a4bf8fed85cde603"
    )

}