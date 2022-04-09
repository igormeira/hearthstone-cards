package com.igormeira.hearthstonecards.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igormeira.hearthstonecards.core.extensions.logger
import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.usecase.AllCardsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class HomeViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val useCase: AllCardsUseCase
) : ViewModel() {

    fun loadAllCards() {
        viewModelScope.launch(dispatcher) {
            useCase.getAllCards().fold(::onFailure, ::onSuccess)
        }
    }

    private fun onFailure(failure: Failure) {
        println("$failure")
    }

    private fun onSuccess(response: AllCardsResponse) {
        println(response.basicCards[0].name)
    }

}