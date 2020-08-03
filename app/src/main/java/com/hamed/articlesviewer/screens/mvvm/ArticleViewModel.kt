package com.hamed.articlesviewer.screens.mvvm

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamed.articlesviewer.BuildConfig
import com.hamed.articlesviewer.mapper.toArticles
import com.hamed.core.model.Article
import com.hamed.core.util.getformatedDate
import com.hamed.repository.repository.NewsRepository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        GlobalScope.launch(Dispatchers.Default) {
            try {
                articles.postValue(
                    repository.getArticlesByCoroutine(
                        q = "bitcoin",
                        from = getformatedDate(selectedDate!!),
                        sortBy = "publishedAt",
                        apiKey = BuildConfig.API_NEWS_KEY
                    ).toArticles()
                )
            } catch (e: Exception) {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(context, "Sorry, an error happened", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}