package com.igormeira.hearthstonecards.ui.fragments.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.igormeira.hearthstonecards.databinding.CardFragmentBinding
import com.igormeira.hearthstonecards.di.cardModule
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class CardFragment : Fragment() {

    private val cardModules by lazy {
        unloadKoinModules(cardModule)
        loadKoinModules(cardModule)
    }

    private fun injectModules() = cardModules

    private val cardViewModel: CardViewModel by viewModel()

    private lateinit var binding: CardFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectModules()
        initScreen()
    }

    private fun initScreen() {
        initObservers()
        cardViewModel.loadCardInfo("Fireblast")
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            cardViewModel.sharedFlow.collectLatest { data ->
                binding.tvCardName.text = data.name
            }
        }
    }

}