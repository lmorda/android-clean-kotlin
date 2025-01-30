package com.lmorda.data.di

import com.lmorda.data.DataRepositoryImpl
import com.lmorda.data.mapper.GithubRepoMapper
import com.lmorda.domain.DataRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<DataRepository> {
        DataRepositoryImpl(
            apiService = get(),
            mapper = GithubRepoMapper(),
        )
    }
}
