package com.tech.onlinematka.ui.privay_policy

import android.app.ActionBar
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.tech.onlinematka.HomeScreenActivity
import com.tech.onlinematka.R

class PrivacyFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var inflater=LayoutInflater.from(context)
        inflater.inflate(R.layout.fragment_privacy_policy, container, false)

        var dialog= Dialog(requireContext())
        dialog.setTitle("Privacy Policy")
        dialog.setContentView(R.layout.privacy_policy_dialog)

        dialog.setCanceledOnTouchOutside(false)

        var btn_ok=dialog.findViewById(R.id.btn_ok) as TextView
        btn_ok.setOnClickListener {
            dialog.dismiss()
            var intent=Intent(activity,HomeScreenActivity::class.java)
            requireContext().startActivity(intent)
        }



        dialog.show()
        val window: Window? =dialog.window
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
        return view
    }
}