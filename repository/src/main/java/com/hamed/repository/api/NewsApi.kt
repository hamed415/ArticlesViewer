package com.hamed.repository.api

import com.hamed.repository.model.NewsApiModel
import io.reactivex.Single
import io.reactivex.annotations.CheckReturnValue
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @CheckReturnValue
    @GET("everything")
    fun getArticles(
        @Query(value = "q") q: String,
        @Query(value = "from") from: String,
        @Query(value = "sortBy") sortBy: String,
        @Query(value = "apiKey") apiKey: String
    ): Single<NewsApiModel>

}