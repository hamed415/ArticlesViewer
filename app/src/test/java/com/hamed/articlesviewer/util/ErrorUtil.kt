package com.hamed.articlesviewer.util

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response


var response404: Response<Void> = Response.error(
    404,
    ResponseBody.create(
        "application/json".toMediaType(),
        "{\"key\": [\"not found error\"]}"
    )
)

var http404Exception = HttpException(response404)