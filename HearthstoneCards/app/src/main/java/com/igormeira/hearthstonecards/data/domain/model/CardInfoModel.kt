package com.igormeira.hearthstonecards.data.domain.model

import com.igormeira.hearthstonecards.util.CardRarity

data class CardInfoModel(
    val name: String,
    val description: String? = "",
    val playerClass: String?,
    val cost: Int?,
    val rarity: String? = CardRarity.FREE.name,
    val attack: Int?,
    val health: Int?,
    val imageUrl: String? = ""
)
