package com.igormeira.hearthstonecards.data.datasource

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse

interface AllCardsDataSource {

    suspend fun getAllCards(): Resource<Failure, AllCardsResponse>

}