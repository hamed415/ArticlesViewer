package com.hamed.articlesviewer.screens.mvvm

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamed.articlesviewer.BuildConfig
import com.hamed.articlesviewer.mapper.toArticles
import com.hamed.core.model.Article
import com.hamed.core.util.getFormattedDate
import com.hamed.repository.repository.NewsRepository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.time.LocalDateTime

class ArticleViewModel : ViewModel(), KoinComponent {

    private val repository: NewsRepository by inject()
    private val context: Context by inject()

    var articles = MutableLiveData<List<Article>>()
    var selectedDate: LocalDateTime? = null

    private val composite: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun getArticlesByDate(date: LocalDateTime) {
        selectedDate = date
        getArticles()
    }

    private fun getArticles() {

        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(context, "Sorry, an error happened", Toast.LENGTH_LONG).show()
            }
        }

        GlobalScope.launch(exceptionHandler + Dispatchers.IO) {
            selectedDate?.let { date ->
                articles.postValue(
                    repository.getArticlesByCoroutine(
                        q = "bitcoin",
                        from = getFormattedDate(date),
                        sortBy = "publishedAt",
                        apiKey = BuildConfig.API_NEWS_KEY
                    ).toArticles()
                )
            }
        }
    }
}