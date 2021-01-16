package com.tech.onlinematka.ui.withdraw_history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WithdrawViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is withdraw history Fragment"
    }
    val text: LiveData<String> = _text
}