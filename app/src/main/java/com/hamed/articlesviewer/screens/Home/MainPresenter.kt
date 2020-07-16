package com.hamed.articlesviewer.screens.home

import android.util.Log
import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.util.getformatedDate
import com.hamed.navigation.base.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import java.time.LocalDateTime

class MainPresenter : BasePresenterImpl<Main.MainView>(),
    Main.MainPresenter, KoinComponent {
    private val interactor by lazy {
        MainInteractor()
    }


    override fun getArticlesList() {
        composite.add(interactor.getArticles(
            GetArticlesUsecase.params(
                q = "bitcoin",
                from = getformatedDate(LocalDateTime.now().minusDays(1)),
                sortBy = "publishedAt"
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.updateList(it)
                },
                {
                    Log.d("hamed", " error $it")
                }
            )
        )
    }

}