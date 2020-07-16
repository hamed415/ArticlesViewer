package com.hamed.articlesviewer.mapper

import com.hamed.core.model.Article
import com.hamed.repository.model.NewsApiModel

fun NewsApiModel.toArticles(): List<Article> {
    return articles.map {
        Article(
            source = it.source.name ?: "Empty source",
            author = it.author ?: "Empty author",
            title = it.title ?: "Empty title",
            description = it.description ?: "Empty description",
            url = it.url ?: "",
            urlToImage = it.urlToImage ?: ""
        )
    }
}