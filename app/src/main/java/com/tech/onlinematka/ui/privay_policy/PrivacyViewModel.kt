package com.tech.onlinematka.ui.privay_policy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PrivacyViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is privacy Fragment"
    }
    val text: LiveData<String> = _text
}