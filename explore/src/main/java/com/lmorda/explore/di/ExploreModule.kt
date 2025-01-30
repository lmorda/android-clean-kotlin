package com.lmorda.explore.di

import com.lmorda.explore.details.DetailsViewModel
import com.lmorda.explore.list.ExploreViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val exploreModule = module {
    viewModel { ExploreViewModel(get()) }
    viewModel { DetailsViewModel(get(), get()) }
}
