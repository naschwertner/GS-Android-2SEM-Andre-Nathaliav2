package com.example.gs2semandrenathalia.View

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gs2semandrenathalia.ViewModel.AlertasViewModel
import com.example.gs2semandrenathalia.databinding.FragmentAlertasBinding
import java.util.*

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
        val etMaintenanceDate = binding.etMaintenanceDate

        slideshowViewModel.text.observe(viewLifecycleOwner) {
            alertTitle.text = it
        }

        etMaintenanceDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "${selectedDayOfMonth}/${selectedMonth + 1}/$selectedYear"
                etMaintenanceDate.setText(selectedDate)
            }, year, month, day).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
