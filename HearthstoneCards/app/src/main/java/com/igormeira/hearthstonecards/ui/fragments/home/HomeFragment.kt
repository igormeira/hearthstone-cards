package com.igormeira.hearthstonecards.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.igormeira.hearthstonecards.databinding.HomeFragmentBinding
import com.igormeira.hearthstonecards.di.homeModule
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
        homeViewModel.loadAllCards()
    }

}