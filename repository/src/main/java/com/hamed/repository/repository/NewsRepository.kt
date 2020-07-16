package com.hamed.repository.repository

import com.hamed.repository.api.NewsApi
import com.hamed.repository.factory.NewsFactory
import org.koin.core.KoinComponent
import org.koin.core.inject

open class NewsRepository : KoinComponent {
    private val newsFactory: NewsFactory by inject()

    private val basicNews by lazy {
        newsFactory.getNews<NewsApi>()
    }

    fun getArticles(
        q: String,
        from: String,
        sortBy: String,
        apiKey: String
    ) = basicNews.getArticles(q, from, sortBy, apiKey)
}