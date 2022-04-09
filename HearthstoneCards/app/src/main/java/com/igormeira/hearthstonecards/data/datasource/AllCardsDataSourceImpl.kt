package com.igormeira.hearthstonecards.data.datasource

import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.core.network.Resource
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.data.remote.ApiAccess

class AllCardsDataSourceImpl : AllCardsDataSource {

    private val apiAccess = ApiAccess

    override suspend fun getAllCards(): Resource<Failure, AllCardsResponse> {
        return try {
            val response = apiAccess.client.getAllCards().execute()
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