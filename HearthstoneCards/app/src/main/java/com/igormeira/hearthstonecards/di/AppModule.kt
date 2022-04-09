package com.igormeira.hearthstonecards.di

import android.app.Application
import com.igormeira.hearthstonecards.data.datasource.AllCardsDataSource
import com.igormeira.hearthstonecards.data.datasource.AllCardsDataSourceImpl
import com.igormeira.hearthstonecards.data.remote.ApiAccess
import com.igormeira.hearthstonecards.data.repository.AllCardsRepository
import com.igormeira.hearthstonecards.data.repository.AllCardsRepositoryImpl
import com.igormeira.hearthstonecards.ui.fragments.home.HomeViewModel
import com.igormeira.hearthstonecards.usecase.AllCardsUseCase
import com.igormeira.hearthstonecards.usecase.AllCardsUseCaseImpl
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val clientModule = module {

}

val homeModule = module {
    singleOf(::AllCardsDataSourceImpl) bind AllCardsDataSource::class
    singleOf(::AllCardsRepositoryImpl) bind AllCardsRepository::class

    viewModel { HomeViewModel(Dispatchers.IO, get()) }

    factoryOf(::AllCardsUseCaseImpl) bind AllCardsUseCase::class
}

class AppModule: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            androidContext(this@AppModule)
            modules(listOf(clientModule, homeModule))
        }
    }
}