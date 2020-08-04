package com.hamed.articlesviewer.usecase

import com.hamed.articlesviewer.BaseKoinTest
import com.hamed.articlesviewer.BuildConfig
import com.hamed.articlesviewer.util.http404Exception
import com.hamed.core.model.Article
import com.hamed.repository.model.ArticlesApiModel
import com.hamed.repository.model.NewsApiModel
import com.hamed.repository.model.SourceApiModel
import com.hamed.repository.repository.NewsRepository
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import org.junit.Test
import org.koin.test.mock.declareMock

class UsecaseTest : BaseKoinTest() {

    private val articles = listOf(
        Article(
            source = "Cointelegraph",
            author = "Cointelegraph By Guest Authors",
            title = "Things to Consider When Giving Crypto to Charities or Others",
            description = "Here are some important things to know before giving donations in cryptocurrency for charitable purposes.",
            url = "https://cointelegraph.com/news/things-to-consider-when-giving-crypto-to-charities-or-others",
            urlToImage = "https://s3.cointelegraph.com/storage/uploads/view/9cc9fc745b19554ab11fafbc9d113a50.jpg"
        )
    )

    private val newsApiModel = NewsApiModel().apply {
        status = "OK"
        totalResults = ""
        articles = listOf(ArticlesApiModel().apply {
            source = SourceApiModel().apply {
                id = "id"
                name = "Cointelegraph"
            }
            author = "Cointelegraph By Guest Authors"
            title = "Things to Consider When Giving Crypto to Charities or Others"
            description =
                "Here are some important things to know before giving donations in cryptocurrency for charitable purposes."
            url =
                "https://cointelegraph.com/news/things-to-consider-when-giving-crypto-to-charities-or-others"
            urlToImage =
                "https://s3.cointelegraph.com/storage/uploads/view/9cc9fc745b19554ab11fafbc9d113a50.jpg"
            publishedAt = null
            content = null
        })
    }

    @Test
    fun getArticlesUsecaseSuccessTest() {
        declareMock<NewsRepository> {
            given(
                this.getArticles(
                    q = "bitcoin",
                    from = "2020-07-25",
                    sortBy = "publishedAt",
                    apiKey = BuildConfig.API_NEWS_KEY
                )
            ).willReturn(Single.just(newsApiModel))
        }

        GetArticlesUsecase()
            .getSingle(
                GetArticlesUsecase.Params(
                    q = "bitcoin",
                    from = "2020-07-25",
                    sortBy = "publishedAt"
                )
            )
            .test()
            .assertComplete()
            .assertResult(
                articles
            )

    }

    @Test
    fun getArticlesUsecaseFailTest() {
        declareMock<NewsRepository> {
            given(
                this.getArticles(
                    q = "bitcoin",
                    from = "2020-07-25",
                    sortBy = "publishedAt",
                    apiKey = BuildConfig.API_NEWS_KEY
                )
            ).willReturn(Single.error(http404Exception))
        }

        GetArticlesUsecase()
            .getSingle(
                GetArticlesUsecase.Params(
                    q = "bitcoin",
                    from = "2020-07-25",
                    sortBy = "publishedAt"
                )
            )
            .test()
            .assertNotComplete()
            .assertError(http404Exception)

    }

}