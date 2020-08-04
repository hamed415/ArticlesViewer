package com.hamed.repository.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticlesApiModel(
    @SerializedName("source")
    var source: SourceApiModel = SourceApiModel(),
    @SerializedName("author")
    var author: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("urlToImage")
    var urlToImage: String? = null,
    @SerializedName("publishedAt")
    var publishedAt: String? = null,
    @SerializedName("content")
    var content: String? = null
) : Parcelable