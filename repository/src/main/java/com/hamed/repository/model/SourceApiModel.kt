package com.hamed.repository.model

import com.google.gson.annotations.SerializedName

data class SourceApiModel(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String = ""
)