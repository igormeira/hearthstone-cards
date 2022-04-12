package com.igormeira.hearthstonecards.data.remote

import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.data.domain.response.CardInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiClient {

    @GET("/cards")
    fun getAllCards(
        @Header(KEY_HEADER) key: String? = API_KEY
    ): Call<AllCardsResponse>

    @GET("/cards/{name}")
    fun getCardInfo(
        @Path("name") cardName: String
    ): Call<List<CardInfoResponse>>

    companion object {
        private const val KEY_HEADER = "X-RapidAPI-Key"
        private const val API_KEY: String = "acd868476bmsh57add3b8375578fp15c983jsnfac20bbd328e"
    }
}