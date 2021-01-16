package com.tech.onlinematka.ui.ratechart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RateChartViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is rate chart Fragment"
    }
    val text: LiveData<String> = _text
}