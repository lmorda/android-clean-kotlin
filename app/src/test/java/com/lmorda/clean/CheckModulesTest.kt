package com.lmorda.clean

import com.lmorda.data.di.dataModule
import com.lmorda.data.di.repositoryModule
import com.lmorda.explore.di.exploreModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class CheckModulesTest : KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() {
        dataModule.verify()
        exploreModule.verify()
        repositoryModule.verify()
    }
}
