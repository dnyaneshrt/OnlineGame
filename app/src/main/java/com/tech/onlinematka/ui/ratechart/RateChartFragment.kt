package com.tech.onlinematka.ui.ratechart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.onlinematka.R

class RateChartFragment: Fragment() {

    private lateinit var rateChartViewModel: RateChartViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rateChartViewModel =
            ViewModelProvider(this).get(RateChartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rate_chart, container, false)
        val textView: TextView = root.findViewById(R.id.text_rate_chart)
        rateChartViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}