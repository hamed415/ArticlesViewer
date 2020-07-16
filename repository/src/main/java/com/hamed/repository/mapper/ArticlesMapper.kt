package com.hamed.repository.mapper

import com.hamed.core.model.Articles
import com.hamed.repository.model.NewsApiModel

fun NewsApiModel.toArticles(): List<Articles> {
    return articles.map {
        Articles(
            source = it.source.name,
            author = it.author,
            title = it.title,
            description = it.description,
            url = it.url,
            urlToImage = it.urlToImage
        )
    }
}