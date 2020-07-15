package com.hamed.repository.model

import com.google.gson.annotations.SerializedName

data class ArticlesApiModel(
    @SerializedName("source")
    var source: SourceApiModel = SourceApiModel(),
    @SerializedName("author")
    var author: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("urlToImage")
    var urlToImage: String = "",
    @SerializedName("publishedAt")
    var publishedAt: String = "",
    @SerializedName("content")
    var content: String = ""
)