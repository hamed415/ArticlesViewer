package com.hamed.articlesviewer.dependencyinjection

import com.hamed.repository.repository.NewsRepository
import org.koin.dsl.module

val appModule = module {
    single { NewsRepository() }
}