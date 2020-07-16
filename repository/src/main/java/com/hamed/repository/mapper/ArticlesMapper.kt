package com.hamed.repository.mapper

import com.hamed.core.model.Articles
import com.hamed.repository.model.NewsApiModel

fun NewsApiModel.toArticles(): List<Articles> {
    return articles.map {
        Articles(
            source = it.source.name ?: "Empty name",
            author = it.author ?: "Empty author",
            title = it.title ?: "Empty title",
            description = it.description ?: "Empty description",
            url = it.url ?: "",
            urlToImage = it.urlToImage ?: ""
        )
    }
}