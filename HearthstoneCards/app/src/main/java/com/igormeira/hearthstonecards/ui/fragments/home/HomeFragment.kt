package com.igormeira.hearthstonecards.ui.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.igormeira.hearthstonecards.databinding.HomeFragmentBinding
import com.igormeira.hearthstonecards.di.homeModule
import com.igormeira.hearthstonecards.ui.fragments.home.adapters.CardListRecyclerAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class HomeFragment : Fragment() {

    private val homeModules by lazy {
        unloadKoinModules(homeModule)
        loadKoinModules(homeModule)
    }

    private fun injectModules() = homeModules

    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var binding: HomeFragmentBinding

    private lateinit var cardsAdapter: CardListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectModules()
        initScreen()
    }

    private fun initScreen() {
        initObservers()
        initAdapters()
        homeViewModel.loadAllCards()
    }

    private fun initAdapters() {
        binding.recyclerHome.apply {
            layoutManager = LinearLayoutManager(requireContext())
            cardsAdapter = CardListRecyclerAdapter(::onClickCard)
            adapter = cardsAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            homeViewModel.sharedFlow.collectLatest { data ->
                cardsAdapter.setCardsList(newList = data.cards)
                cardsAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun onClickCard(name: String) {

    }

}