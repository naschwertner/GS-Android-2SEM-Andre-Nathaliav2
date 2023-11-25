package com.example.gs2semandrenathalia.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gs2semandrenathalia.Models.ResponseBody.ResponseBody
import com.example.gs2semandrenathalia.ViewModel.RandomNumbersViewModel
import com.example.gs2semandrenathalia.ViewModel.RandomNumbersViewModelFactory
import com.example.gs2semandrenathalia.databinding.FragmentSensorBinding

class SensorFragment : Fragment() {

    private var _binding: FragmentSensorBinding? = null


    private val binding get() = _binding!!

    private val randFactory = RandomNumbersViewModelFactory()
    private lateinit var viewModel: RandomNumbersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSensorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ViewModelProvider(this, randFactory)[RandomNumbersViewModel::class.java]
        setupObservers()

        viewModel.invokeNumbers()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {
        viewModel.liveResponseBody.observe(
            viewLifecycleOwner,
            Observer(::setResponseBody)
        )
        viewModel.liveError.observe(
            viewLifecycleOwner,
            Observer(::showErrors)
        )
    }

    private fun setResponseBody(responseBody: ResponseBody?) {
        _binding?.pbCloro?.progress = responseBody?.result?.random?.data?.get(0)!!
        _binding?.pbCloroNumber?.text = responseBody.result.random.data[0].toString() + "%"
        _binding?.pbTurbidez?.progress = responseBody.result.random.data.get(1)
        _binding?.pbTurbidezNumber?.text = responseBody.result.random.data[1].toString() + "%"
        _binding?.pbNitratos?.progress = responseBody.result.random.data.get(2)
        _binding?.pbNitratosNumber?.text = responseBody.result.random.data[2].toString() + "%"
        _binding?.pbFosfatos?.progress = responseBody.result.random.data.get(3)
        _binding?.pbFosfatosNumber?.text = responseBody.result.random.data[3].toString() + "%"
        _binding?.pbRedox?.progress = responseBody.result.random.data.get(4)
        _binding?.pbRedoxNumber?.text = responseBody.result.random.data[4].toString() + "%"
        _binding?.pbPh?.progress = responseBody.result.random.data.get(5)
        _binding?.pbPhNumber?.text = responseBody.result.random.data[5].toString() + "%"

    }

    private fun showErrors(error: String?) {
        //TODO
    }
}
