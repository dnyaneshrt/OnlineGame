package com.tech.onlinematka.ui.exit

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.tech.onlinematka.LoginActivity
import com.tech.onlinematka.R

class ExitFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.fragment_exit, container, false)

        var dialog = AlertDialog.Builder(activity)
        dialog.setTitle("Log out")
        dialog.setMessage("are u sure,you want to log out?")

        var listener = DialogInterface.OnClickListener { dialog, which ->
            if (which == Dialog.BUTTON_POSITIVE) {
                FirebaseAuth.getInstance().signOut()
                var intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            } else if (which == Dialog.BUTTON_NEGATIVE) {
                dialog.dismiss()
            } else if (which == Dialog.BUTTON_NEUTRAL) {
                dialog.dismiss()
            }
        }
        dialog.setPositiveButton("yes", listener)
        dialog.setNegativeButton("no", listener)
        dialog.setNeutralButton("cancel", listener)

        dialog.show()

        return view
    }
}