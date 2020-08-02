package com.hamed.articlesviewer.dependencyinjection

import android.app.Application
import com.hamed.articlesviewer.screens.home.MainInteractor
import com.hamed.articlesviewer.screens.mvvm.ArticleViewModel
import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import com.hamed.core.rx.SchedulerProviderImpl
import org.koin.dsl.module

val appModule = module {
    single { MainInteractor() }
    single { GetArticlesUsecase() }
    single { ArticleViewModel() }
    single { SchedulerProviderImpl() }
}