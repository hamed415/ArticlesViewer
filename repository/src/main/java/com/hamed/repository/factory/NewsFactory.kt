package com.hamed.repository.factory

import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NewsFactory {

    val baseUrl =  "http://newsapi.org/v2/"
    inline fun <reified T> getNews(): T {
        val gson = GsonBuilder().setLenient().create()

        val okHttpClientBuilder = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(T::class.java)
    }

    val client by lazy {
        val builder = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(httpLoggingInterceptor)

        builder.addNetworkInterceptor(StethoInterceptor())

        val client = builder.build()
        val resource: IdlingResource = OkHttp3IdlingResource.create("OkHttp", client)
        IdlingRegistry.getInstance().register(resource)

        client
    }
}