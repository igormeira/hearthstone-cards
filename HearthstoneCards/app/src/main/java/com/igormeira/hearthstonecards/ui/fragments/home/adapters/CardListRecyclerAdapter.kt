package com.igormeira.hearthstonecards.ui.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.igormeira.hearthstonecards.data.domain.model.CardListItemModel
import com.igormeira.hearthstonecards.databinding.CardListItemViewBinding

class CardListRecyclerAdapter(
    private val clickedCallback: (String) -> Unit
) : RecyclerView.Adapter<CardListViewHolder>() {

    private var cardsList: List<CardListItemModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder {
        val itemBinding = CardListItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CardListViewHolder(itemBinding, clickedCallback)

    }

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        holder.bind(cardsList[position])
    }

    override fun getItemCount() = cardsList.size

    fun setCardsList(newList: List<CardListItemModel>) {
        cardsList = newList
    }
}