package com.hamed.repository.news

import com.hamed.repository.model.NewsApiModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("everything")
    fun getArticles(
        @Query(value = "q") q: String,
        @Query(value = "from") from: String,
        @Query(value = "sortBy") sortBy: String,
        @Query(value = "apiKey") apiKey: String
    ): Single<NewsApiModel>

}