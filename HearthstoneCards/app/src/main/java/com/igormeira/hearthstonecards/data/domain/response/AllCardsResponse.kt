package com.igormeira.hearthstonecards.data.domain.response

import com.google.gson.annotations.SerializedName

data class AllCardsResponse(
    @SerializedName("Basic") val basicCards: List<AllCardsItemResponse>,
    @SerializedName("Classic") val classicCards: List<AllCardsItemResponse>,
    @SerializedName("Hall of Fame") val hallOfFameCards: List<AllCardsItemResponse>
)
