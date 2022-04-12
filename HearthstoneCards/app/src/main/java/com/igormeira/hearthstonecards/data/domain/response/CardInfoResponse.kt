package com.igormeira.hearthstonecards.data.domain.response

import com.google.gson.annotations.SerializedName

data class CardInfoResponse(
    @SerializedName("cardId") val cardId: String? = "",
    @SerializedName("dbfId") val dbfId: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("cardSet") val cardSet: String? = "",
    @SerializedName("type") val type: String? = "",
    @SerializedName("rarity") val rarity: String? = "",
    @SerializedName("cost") val cost: Int? = 0,
    @SerializedName("attack") val attack: Int? = 0,
    @SerializedName("health") val health: Int? = 0,
    @SerializedName("text") val description: String? = "",
    @SerializedName("flavor") val flavor: String? = "",
    @SerializedName("artist") val artist: String? = "",
    @SerializedName("collectible") val collectible: Boolean? = false,
    @SerializedName("elite") val elite: Boolean? = false,
    @SerializedName("playerClass") val playerClass: String? = "",
    @SerializedName("race") val race: String? = "",
    @SerializedName("img") val imageUrl: String? = "",
    @SerializedName("imgGold") val imageGoldUrl: String? = "",
    @SerializedName("locale") val locale: String? = "",
    @SerializedName("mechanics") val mechanics: CardMechanicsResponse? =
        CardMechanicsResponse(name = "")
)
