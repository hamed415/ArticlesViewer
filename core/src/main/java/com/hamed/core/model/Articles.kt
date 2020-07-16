package com.hamed.core.model

data class Articles (
    var source: String,
    var author: String = "",
    var title: String = "",
    var description: String = "",
    var url: String = "",
    var urlToImage: String = ""
)