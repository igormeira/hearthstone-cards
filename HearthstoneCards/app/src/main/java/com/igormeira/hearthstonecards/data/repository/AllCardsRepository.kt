package com.igormeira.hearthstonecards.data.repository

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse

interface AllCardsRepository {

    suspend fun getAllCards(): Resource<Failure, AllCardsResponse>

}