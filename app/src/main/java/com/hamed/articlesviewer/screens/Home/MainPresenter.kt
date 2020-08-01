package com.hamed.articlesviewer.screens.home

import android.util.Log
import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.util.getformatedDate
import com.hamed.navigation.base.BasePresenterImpl
import com.hamed.navigation.base.BaseView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.time.LocalDateTime

class MainPresenter : BasePresenterImpl<Main.MainView>(),
    Main.MainPresenter, KoinComponent {

    private val interactor: MainInteractor by inject()
    private var selectedDate = LocalDateTime.now().minusDays(1)

    override fun getArticlesList() {
        checkMaxDate()
        checkMinDate()
        composite.add(interactor.getArticles(
            GetArticlesUsecase.params(
                q = "bitcoin",
                from = getformatedDate(selectedDate),
                sortBy = "publishedAt"
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    view?.let {
                        it.updateList(list)
                        it.updateDate(getformatedDate(selectedDate))
                    }
                },
                {
                    Log.d("hamed", " error $it")
                }
            )
        )
    }

    override fun dateIncrement(){
        selectedDate = selectedDate.plusDays(1)
        getArticlesList()
    }

    override fun dateDecrement(){
        selectedDate = selectedDate.minusDays(1)
        getArticlesList()
    }

    private fun checkMaxDate(){
        view?.let {
            it.displayDateIncrement(selectedDate.plusDays(1).toLocalDate() != LocalDateTime.now().toLocalDate())
        }
    }

    private fun checkMinDate() {
        view?.let {
            it.displayDateDecrement(selectedDate.minusDays(1).toLocalDate() != LocalDateTime.now().minusDays(10).toLocalDate())
        }
    }
}