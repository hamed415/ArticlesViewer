package com.hamed.repository.factory

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewsFactory {
    val baseUrl = "http://newsapi.org/v2/"
    val okHttpClientBuilder = OkHttpClient.Builder().build()
    val gson = GsonBuilder().setLenient().create()


    inline fun <reified T> getNews(): T {

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClientBuilder)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(T::class.java)
    }

    inline fun <reified T> getNewsByFlow(): T {

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClientBuilder)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(T::class.java)
    }

}