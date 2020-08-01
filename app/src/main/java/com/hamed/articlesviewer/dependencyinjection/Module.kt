package com.hamed.articlesviewer.dependencyinjection

import com.hamed.articlesviewer.screens.home.MainInteractor
import com.hamed.articlesviewer.screens.mvvm.ArticleViewModel
import com.hamed.articlesviewer.usecase.GetArticlesUsecase
import org.koin.dsl.module

val appModule = module {
    single { MainInteractor() }
    single { GetArticlesUsecase() }
    single { ArticleViewModel() }
}