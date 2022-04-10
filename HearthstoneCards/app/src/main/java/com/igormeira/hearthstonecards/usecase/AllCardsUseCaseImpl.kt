package com.igormeira.hearthstonecards.usecase

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.model.AllCardsListModel
import com.igormeira.hearthstonecards.data.domain.model.CardListItemModel
import com.igormeira.hearthstonecards.data.domain.response.AllCardsItemResponse
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.data.repository.AllCardsRepository

class AllCardsUseCaseImpl(
    private val repository: AllCardsRepository
) : AllCardsUseCase {

    override suspend fun getAllCards(): Resource<Failure, AllCardsListModel> {
        return when (val response = repository.getAllCards()) {
            is Resource.Success -> Resource.Success(mapToModel(response.s))
            is Resource.Error -> response
        }
    }

    private fun mapToModel(cards: AllCardsResponse): AllCardsListModel {
        val model = arrayListOf<CardListItemModel>()
        model.addAll(getList(cards.basicCards))
        model.addAll(getList(cards.classicCards))
        model.addAll(getList(cards.hallOfFameCards))
        return AllCardsListModel(cards = model)
    }

    private fun getList(items: List<AllCardsItemResponse>): List<CardListItemModel> {
        val model = arrayListOf<CardListItemModel>()
        for (item in items) {
            val card = CardListItemModel(
                name = item.name,
                description = item.textDescription,
                playerClass = item.playerClass,
                cost = item.cost
            )
            model.add(card)
        }
        return model
    }

}