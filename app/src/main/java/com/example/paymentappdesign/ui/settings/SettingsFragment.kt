package com.example.paymentappdesign.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.Settings
import com.example.paymentappdesign.databinding.FragmentSettingsBinding
import com.example.paymentappdesign.ui.common.GridViewItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val settingsAdapter by lazy {
        SettingsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvSettings.adapter = settingsAdapter
        binding.rvSettings.addItemDecoration(GridViewItemDecoration())
        settingsAdapter.setItems(Settings.values().toMutableList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}