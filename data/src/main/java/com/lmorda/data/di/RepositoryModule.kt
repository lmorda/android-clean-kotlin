package com.lmorda.data.di

import com.lmorda.data.DataRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        DataRepositoryImpl(get(), get())
    }
}
