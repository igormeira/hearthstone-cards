package com.igormeira.hearthstonecards.ui.fragments.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igormeira.hearthstonecards.core.extensions.logger
import com.igormeira.hearthstonecards.core.network.Failure
import com.igormeira.hearthstonecards.data.domain.model.CardInfoModel
import com.igormeira.hearthstonecards.usecase.CardInfoUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CardViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val useCase: CardInfoUseCase
    ) : ViewModel() {

        private val _sharedFlow = MutableSharedFlow<CardInfoModel>()
        val sharedFlow = _sharedFlow.asSharedFlow()

        fun loadCardInfo(cardName: String) {
            viewModelScope.launch(dispatcher) {
                useCase.getCardByName(card = cardName).fold(::onFailure, ::onSuccess)
            }
        }

        private fun onFailure(failure: Failure) {
            println("$failure")
        }

        private fun onSuccess(response: CardInfoModel) {
            logger(response.toString())
            viewModelScope.launch {
                _sharedFlow.emit(response)
            }
        }

    }