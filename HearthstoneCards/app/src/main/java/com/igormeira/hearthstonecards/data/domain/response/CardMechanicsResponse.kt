package com.igormeira.hearthstonecards.data.domain.response

import com.google.gson.annotations.SerializedName

data class CardMechanicsResponse(
     @SerializedName("name") val name: String
)
