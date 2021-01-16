package com.tech.onlinematka.ui.privay_policy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.onlinematka.R

class PrivacyFragment: Fragment() {

    private lateinit var privacyViewModel: PrivacyViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        privacyViewModel =
            ViewModelProvider(this).get(PrivacyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_privacy_policy, container, false)
        val textView: TextView = root.findViewById(R.id.text_privacy_policy)
        privacyViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}