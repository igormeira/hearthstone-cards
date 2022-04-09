package com.igormeira.hearthstonecards.data.repository

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.datasource.AllCardsDataSource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse

class AllCardsRepositoryImpl(
    private val dataSource: AllCardsDataSource
) : AllCardsRepository {

    override suspend fun getAllCards(): Resource<Failure, AllCardsResponse> {
        return dataSource.getAllCards()
    }

}