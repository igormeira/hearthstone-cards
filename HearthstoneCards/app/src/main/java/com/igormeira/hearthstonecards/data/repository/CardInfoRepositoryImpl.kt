package com.igormeira.hearthstonecards.data.repository

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.datasource.AllCardsDataSource
import com.igormeira.hearthstonecards.data.datasource.CardInfoDataSource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.data.domain.response.CardInfoResponse

class CardInfoRepositoryImpl(
    private val dataSource: CardInfoDataSource
) : CardInfoRepository {

    override suspend fun getCardByName(card: String): Resource<Failure, List<CardInfoResponse>> {
        return dataSource.getCardByName(card = card)
    }

}