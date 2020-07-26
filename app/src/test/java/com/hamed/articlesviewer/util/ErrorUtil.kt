package com.hamed.articlesviewer.util

import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.lang.Exception


var response404: Response<Void> = Response.error(
    404,
    ResponseBody.create(
        MediaType.get("application/json"),
        "{\"key\": [\"not found error\"]}"
    )
)

var http404Exception = HttpException(response404)