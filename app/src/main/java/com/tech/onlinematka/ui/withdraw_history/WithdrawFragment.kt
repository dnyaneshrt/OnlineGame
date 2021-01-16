package com.tech.onlinematka.ui.withdraw_history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.onlinematka.R

class WithdrawFragment : Fragment() {

    private lateinit var withdrawViewModel: WithdrawViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        withdrawViewModel =
            ViewModelProvider(this).get(WithdrawViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_withdraw_history, container, false)
        val textView: TextView = root.findViewById(R.id.text_withdraw_history)
        withdrawViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}