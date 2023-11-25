package com.example.gs2semandrenathalia.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gs2semandrenathalia.R
import com.example.gs2semandrenathalia.ViewModel.HomeViewModel
import com.example.gs2semandrenathalia.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSensorDetails.setOnClickListener { goToSensorDetailsFragment() }
        binding.btnAlerts.setOnClickListener { goToAlertsFragment() }

        return root
    }

    private fun goToSensorDetailsFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_sensorFragment)
    }

    private fun goToAlertsFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_alertasFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
