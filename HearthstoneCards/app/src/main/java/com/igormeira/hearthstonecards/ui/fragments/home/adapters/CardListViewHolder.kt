package com.igormeira.hearthstonecards.ui.fragments.home.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.igormeira.hearthstonecards.data.domain.model.CardListItemModel
import com.igormeira.hearthstonecards.databinding.CardListItemViewBinding

class CardListViewHolder(
    private val itemBinding: CardListItemViewBinding,
    private val clickedCallback: (String) -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(card: CardListItemModel) {
        itemBinding.tvItemTitle.text = card.name
        itemBinding.tvItemDescription.text = card.description
        itemBinding.tvItemClassValue.text = card.playerClass
        itemBinding.tvItemCostValue.text = card.cost.toString()
    }

}