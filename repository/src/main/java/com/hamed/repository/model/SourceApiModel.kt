package com.hamed.repository.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SourceApiModel(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String = ""
) : Parcelable