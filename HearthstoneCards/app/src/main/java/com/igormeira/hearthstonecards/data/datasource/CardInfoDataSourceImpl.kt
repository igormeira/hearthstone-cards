package com.igormeira.hearthstonecards.data.datasource

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.data.domain.response.CardInfoResponse
import com.igormeira.hearthstonecards.data.remote.ApiAccess

class CardInfoDataSourceImpl : CardInfoDataSource {

    private val apiAccess = ApiAccess

    override suspend fun getCardByName(card: String): Resource<Failure, List<CardInfoResponse>> {
        return try {
            val response = apiAccess.client.getCardInfo(cardName = card).execute()
            if (response.isSuccessful && response.body() != null) {
                println(response.body())
                Resource.Success((response.body()!!))
            } else {
                Resource.Error(Failure.NetworkFailure(
                    code = response.code(),
                    message = response.message())
                )
            }
        } catch (e: Throwable) {
            Resource.Error(Failure.ParseFailure(e.message.toString()))
        }
    }

}