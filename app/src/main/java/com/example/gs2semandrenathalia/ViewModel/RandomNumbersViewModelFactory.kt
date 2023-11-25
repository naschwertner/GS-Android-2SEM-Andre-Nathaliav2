package com.example.gs2semandrenathalia.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gs2semandrenathalia.api.NetworkUtils
import retrofit2.Retrofit

class RandomNumbersViewModelFactory (
    private val retroFitClient: Retrofit = NetworkUtils.retrofitInstance("https://api.random.org")
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(RandomNumbersViewModel::class.java) ->
                    RandomNumbersViewModel(retroFitClient)
                else ->
                    throw IllegalArgumentException("Classe desconhecida")
            }
        } as T
    }
}