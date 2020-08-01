package com.hamed.repository.dependencyinjection

import com.hamed.core.rx.SchedulerProviderImpl
import com.hamed.repository.factory.NewsFactory
import com.hamed.repository.repository.NewsRepository
import org.koin.dsl.module

val repoModule = module {
    single { NewsFactory() }
    single { NewsRepository() }
}