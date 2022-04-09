package com.igormeira.hearthstonecards.usecase

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.data.repository.AllCardsRepository

class AllCardsUseCaseImpl(
    private val repository: AllCardsRepository
) : AllCardsUseCase {

    override suspend fun getAllCards(): Resource<Failure, AllCardsResponse> {
        return repository.getAllCards()
    }

}