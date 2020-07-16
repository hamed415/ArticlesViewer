package com.hamed.repository.repository

import com.hamed.repository.BuildConfig
import com.hamed.repository.factory.NewsFactory
import com.hamed.repository.news.NewsApi
import org.koin.core.KoinComponent
import org.koin.core.inject

open class NewsRepository : KoinComponent {
    private val newsFactory: NewsFactory by inject()
    private val basicNews by lazy {
        newsFactory.getNews<NewsApi>()
    }

    fun getArticles() = basicNews.getArticles("bitcoin","2020-06-15", "publishedAt", "6cfe588c32024488a4bf8fed85cde603")

}