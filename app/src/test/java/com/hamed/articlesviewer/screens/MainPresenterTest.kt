package com.hamed.articlesviewer.screens

import com.hamed.articlesviewer.BaseKoinTest
import com.hamed.articlesviewer.BuildConfig
import com.hamed.articlesviewer.screens.home.Main
import com.hamed.articlesviewer.usecase.GetArticlesUsecase
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
import org.mockito.Mock


class MainPresenterTest : BaseKoinTest() {

    @Mock
    lateinit var view: Main.MainView

    @Mock
    lateinit var getArticlesUsecase: GetArticlesUsecase

    private val artices = listOf(
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
                GetArticlesUsecase.params(
                    q = "bitcoin",
                    from = "2020-07-25",
                    sortBy = "publishedAt"
                )
            )
            .test()
            .assertComplete()
            .assertResult(
                artices
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
                GetArticlesUsecase.params(
                    q = "bitcoin",
                    from = "2020-07-25",
                    sortBy = "publishedAt"
                )
            )
            .test()
            .assertNotComplete()
            .assertError(http404Exception)

    }

    @Test
    fun getArticleListTest() {
//        val mainPresenter = MainPresenter()
//        mainPresenter.onAttach(view)

//        Mockito.`when`(getArticles.getSingle(any()))
//            .thenReturn(
//                Single.just(
//                    listOf(
//                        Article(
//                            source = "Cointelegraph",
//                            author = "Cointelegraph By Guest Authors",
//                            title = "Things to Consider When Giving Crypto to Charities or Others",
//                            description = "Here are some important things to know before giving donations in cryptocurrency for charitable purposes.",
//                            url = "https://cointelegraph.com/news/things-to-consider-when-giving-crypto-to-charities-or-others",
//                            urlToImage = "https://s3.cointelegraph.com/storage/uploads/view/9cc9fc745b19554ab11fafbc9d113a50.jpg"
//                        )
//                    )
//                )
//            )

//        declareMock<NewsRepository> {
//            given(
//                this.getArticles(
//                    q = "bitcoin",
//                    from = "2020-07-25",
//                    sortBy = "publishedAt",
//                    apiKey = ""
//                )
//            ).willReturn(Single.just(newsApiModel))
//        }

//        declareMock<GetArticlesUsecase>{
//            given(this.getSingle(
//                GetArticlesUsecase.params(
//                    q = "bitcoin",
//                    from = "2020-07-25",
//                    sortBy = "publishedAt"
//                ))).willReturn(Single.just(artices))
//        }

//        GetArticlesUsecase()
//            .getSingle(
//                GetArticlesUsecase.params(
//                    q = "bitcoin",
//                    from = "2020-07-25",
//                    sortBy = "publishedAt"
//                )
//            )
//            .test()
//            .assertComplete()
//            .assertResult(
//                artices
//            )
//
//
//        verify(getArticlesUsecase, Mockito.times(1)).getSingle(any())
    }
}