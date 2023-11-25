package com.example.gs2semandrenathalia.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlertasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Alertas e notificações"
    }
    val text: LiveData<String> = _text
}