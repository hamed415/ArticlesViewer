package com.hamed.articlesviewer.screens.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamed.articlesviewer.screens.home.MainInteractor
import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.model.Article
import com.hamed.core.util.getformatedDate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.time.LocalDateTime

class ArticleViewModel : ViewModel(), KoinComponent {

    private val getArticlesUsecase: GetArticlesUsecase by inject()
    private val interactor: MainInteractor by inject()

    var articles = MutableLiveData<List<Article>>()
    var selectedDate : LocalDateTime? = null

    private val composite: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun getArticlesByDate(date:LocalDateTime){
        selectedDate = date
        getArticles()
    }
    private fun getArticles() {
        composite.add(interactor.getArticles(
            GetArticlesUsecase.params(
                q = "bitcoin",
                from = getformatedDate(selectedDate!!),
                sortBy = "publishedAt"
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    articles.value = list
                },
                {
                    Log.d("hamed", " error $it")
                }
            )
        )
    }
}