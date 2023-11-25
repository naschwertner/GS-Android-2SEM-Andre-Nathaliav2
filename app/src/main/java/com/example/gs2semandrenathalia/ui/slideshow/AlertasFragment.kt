package com.example.gs2semandrenathalia.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gs2semandrenathalia.databinding.FragmentAlertasBinding

class AlertasFragment : Fragment() {

    private var _binding: FragmentAlertasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel = ViewModelProvider(this)[AlertasViewModel::class.java]

        _binding = FragmentAlertasBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val alertTitle = binding.tvAlertTitle
        val enableNotifications = binding.cbEnableNotifications

        slideshowViewModel.text.observe(viewLifecycleOwner) {
            alertTitle.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
