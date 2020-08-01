package com.hamed.articlesviewer.screens.home

import android.util.Log
import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.rx.SchedulerProviderImpl
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
    private val scheduler : SchedulerProviderImpl by inject()
    private var selectedDate = LocalDateTime.now().minusDays(1)

    override fun getArticlesList() {
        composite.add(interactor.getArticles(
            GetArticlesUsecase.params(
                q = "bitcoin",
                from = getformatedDate(selectedDate),
                sortBy = "publishedAt"
            )
        )
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .subscribe(
                { list ->
                    view?.let {
                        it.updateList(list)
                    }
                },
                {
                    Log.d("hamed", " error $it")
                }
            )
        )
    }
}