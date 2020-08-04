package com.hamed.articlesviewer.util

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response


var response404: Response<Void> = Response.error(
    404,
    "{\"key\": [\"not found error\"]}"
        .toResponseBody("application/json".toMediaType())
)

var http404Exception = HttpException(response404)