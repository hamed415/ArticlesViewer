package com.hamed.repository.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsApiModel(
    @SerializedName("status")
    var status: String = "",
    @SerializedName("totalResults")
    var totalResults: String = "",
    @SerializedName("articles")
    var articles: List<ArticlesApiModel> = listOf()
) : Parcelable