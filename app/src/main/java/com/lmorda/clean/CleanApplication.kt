package com.lmorda.clean

import android.app.Application
import com.lmorda.data.di.dataModule
import com.lmorda.data.di.repositoryModule
import com.lmorda.explore.di.exploreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

class CleanApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@CleanApplication)
            modules(dataModule, exploreModule, repositoryModule)
        }
    }
}
