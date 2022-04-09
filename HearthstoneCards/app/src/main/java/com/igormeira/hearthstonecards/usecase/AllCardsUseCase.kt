package com.igormeira.hearthstonecards.usecase

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse

interface AllCardsUseCase {

    suspend fun getAllCards(): Resource<Failure, AllCardsResponse>

}