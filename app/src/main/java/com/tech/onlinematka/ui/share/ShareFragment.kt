package com.tech.onlinematka.ui.share

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tech.onlinematka.R


class ShareFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      var inflater=LayoutInflater.from(context)
       var view= inflater.inflate(R.layout.fragment_share, container, false)

        var intent= Intent()
        intent.action=Intent.ACTION_SEND
        intent.type = "text/plain"
        var string="Download online Matka app: http://onlinematkas.com/"
        intent.putExtra(Intent.EXTRA_TEXT, string)
        startActivity(Intent.createChooser(intent, "Share via"))




        return view
    }
}