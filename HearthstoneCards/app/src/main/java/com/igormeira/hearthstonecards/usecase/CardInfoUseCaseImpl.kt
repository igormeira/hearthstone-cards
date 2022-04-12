package com.igormeira.hearthstonecards.usecase

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.model.AllCardsListModel
import com.igormeira.hearthstonecards.data.domain.model.CardInfoModel
import com.igormeira.hearthstonecards.data.domain.model.CardListItemModel
import com.igormeira.hearthstonecards.data.domain.response.AllCardsItemResponse
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.data.domain.response.CardInfoResponse
import com.igormeira.hearthstonecards.data.repository.AllCardsRepository
import com.igormeira.hearthstonecards.data.repository.CardInfoRepository

class CardInfoUseCaseImpl(
    private val repository: CardInfoRepository
) : CardInfoUseCase {

    override suspend fun getCardByName(card: String): Resource<Failure, CardInfoModel> {
        return when (val response = repository.getCardByName(card = card)) {
            is Resource.Success -> Resource.Success(mapToModel(response.s))
            is Resource.Error -> response
        }
    }

    private fun mapToModel(cards: List<CardInfoResponse>): CardInfoModel {
        val info = getRightCardInfo(cards)
        return CardInfoModel(
            name = info.name.toString(),
            description = info.description,
            playerClass = info.playerClass,
            cost = info.cost,
            rarity = info.rarity,
            attack = info.attack,
            health = info.health,
            imageUrl = if (!info.imageGoldUrl.isNullOrEmpty()) info.imageGoldUrl else info.imageUrl
        )
    }

    private fun getRightCardInfo(cards: List<CardInfoResponse>): CardInfoResponse {
        for (card in cards) {
            if (!card.imageUrl.isNullOrEmpty() || !card.imageGoldUrl.isNullOrEmpty()) return card
        }
        return CardInfoResponse()
    }
}