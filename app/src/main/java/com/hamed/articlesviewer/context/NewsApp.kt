package com.hamed.articlesviewer.context

import androidx.multidex.MultiDexApplication
import com.hamed.repository.dependencyinjection.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class NewsApp : MultiDexApplication(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            //inject Android context
            androidContext(this@NewsApp)
            // use modules
            modules(
                listOf(repoModule)
            )
        }
    }
}