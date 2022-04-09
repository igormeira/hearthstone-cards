package com.igormeira.hearthstonecards.data.domain.response

import com.google.gson.annotations.SerializedName

data class AllCardsItemResponse(
    @SerializedName("cardId") val cardId: String,
    @SerializedName("dbfId") val dbfId: String,
    @SerializedName("name") val name: String,
    @SerializedName("cardSet") val cardSet: String,
    @SerializedName("type") val type: String,
    @SerializedName("text") val textDescription: String,
    @SerializedName("playerClass") val playerClass: String,
    @SerializedName("locale") val locale: String,
    @SerializedName("mechanics") val mechanicsList: List<CardMechanicsResponse>?,
)
