package com.hamed.articlesviewer.screens.home.interactor

import com.hamed.core.model.Articles
import com.hamed.repository.mapper.toArticles
import com.hamed.repository.repository.NewsRepository
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeInteractor : KoinComponent {
    private val repository: NewsRepository by inject()

    fun getArticles(): Single<List<Articles>> {
        return repository.getArticles()
            .flatMap { Single.just(it.toArticles()) }
    }

}