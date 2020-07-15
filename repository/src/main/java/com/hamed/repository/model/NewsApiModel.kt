package com.hamed.repository.model

import com.google.gson.annotations.SerializedName

data class NewsApiModel (
    @SerializedName("status")
    var status: String = "",
    @SerializedName("totalResults")
    var totalResults: String = "",
    @SerializedName("articles")
    var articles: List<ArticlesApiModel> = listOf()
)