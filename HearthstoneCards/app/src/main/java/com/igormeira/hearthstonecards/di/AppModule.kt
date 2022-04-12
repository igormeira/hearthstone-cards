package com.igormeira.hearthstonecards.di

import android.app.Application
import com.igormeira.hearthstonecards.data.datasource.AllCardsDataSource
import com.igormeira.hearthstonecards.data.datasource.AllCardsDataSourceImpl
import com.igormeira.hearthstonecards.data.datasource.CardInfoDataSource
import com.igormeira.hearthstonecards.data.datasource.CardInfoDataSourceImpl
import com.igormeira.hearthstonecards.data.repository.AllCardsRepository
import com.igormeira.hearthstonecards.data.repository.AllCardsRepositoryImpl
import com.igormeira.hearthstonecards.data.repository.CardInfoRepository
import com.igormeira.hearthstonecards.data.repository.CardInfoRepositoryImpl
import com.igormeira.hearthstonecards.ui.fragments.card.CardViewModel
import com.igormeira.hearthstonecards.ui.fragments.home.HomeViewModel
import com.igormeira.hearthstonecards.usecase.AllCardsUseCase
import com.igormeira.hearthstonecards.usecase.AllCardsUseCaseImpl
import com.igormeira.hearthstonecards.usecase.CardInfoUseCase
import com.igormeira.hearthstonecards.usecase.CardInfoUseCaseImpl
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val cardModule = module {
    singleOf(::CardInfoDataSourceImpl) bind CardInfoDataSource::class
    singleOf(::CardInfoRepositoryImpl) bind CardInfoRepository::class

    viewModel { CardViewModel(Dispatchers.IO, get()) }

    factoryOf(::CardInfoUseCaseImpl) bind CardInfoUseCase::class
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
            modules(listOf(cardModule, homeModule))
        }
    }
}