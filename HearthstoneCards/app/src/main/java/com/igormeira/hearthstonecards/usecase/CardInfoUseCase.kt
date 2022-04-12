package com.igormeira.hearthstonecards.usecase

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.model.CardInfoModel

interface CardInfoUseCase {

    suspend fun getCardByName(card: String): Resource<Failure, CardInfoModel>

}