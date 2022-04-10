package com.igormeira.hearthstonecards.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igormeira.hearthstonecards.core.extensions.logger
import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.data.domain.model.AllCardsListModel
import com.igormeira.hearthstonecards.data.domain.model.CardListItemModel
import com.igormeira.hearthstonecards.data.domain.response.AllCardsResponse
import com.igormeira.hearthstonecards.usecase.AllCardsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val useCase: AllCardsUseCase
) : ViewModel() {

    private val _sharedFlow = MutableSharedFlow<AllCardsListModel>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun loadAllCards() {
        viewModelScope.launch(dispatcher) {
            useCase.getAllCards().fold(::onFailure, ::onSuccess)
        }
    }

    private fun onFailure(failure: Failure) {
        println("$failure")
    }

    private fun onSuccess(response: AllCardsListModel) {
        logger(response.toString())
        viewModelScope.launch {
            _sharedFlow.emit(response)
        }
    }

}