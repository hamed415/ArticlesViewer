package com.hamed.articlesviewer

import com.hamed.articlesviewer.dependencyinjection.appModule
import com.hamed.repository.dependencyinjection.repoModule
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.MockitoAnnotations

open class BaseKoinTest : KoinTest {
    @Before
    open fun setupTests() {
        startKoin {
            modules(listOf(appModule, repoModule))
        }

        MockitoAnnotations.initMocks(this)

    }

    @After
    fun afterTests() {
        stopKoin()
    }
}