package com.igormeira.hearthstonecards.data.repository

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.response.CardInfoResponse

interface CardInfoRepository {

    suspend fun getCardByName(card: String): Resource<Failure, List<CardInfoResponse>>

}