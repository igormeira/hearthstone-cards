package com.igormeira.hearthstonecards.data.domain.model

import com.igormeira.hearthstonecards.util.CardRarity

data class AllCardsListModel(
    val cards: List<CardListItemModel>
)

data class CardListItemModel(
    val name: String,
    val description: String? = "",
    val playerClass: String,
    val cost: Int,
    val rarity: String? = CardRarity.FREE.name
)
