package com.tech.onlinematka.ui.wallet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tech.onlinematka.R

class WalletFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.fragment_wallet, container, false)

        var txt_amount = view.findViewById(R.id.text_amount) as TextView
        var txt_withdraw = view.findViewById(R.id.text_amount) as TextView
        var btn_add = view.findViewById(R.id.btn_add) as Button

        txt_amount.setOnClickListener {
            Toast.makeText(activity, "amount clicked", Toast.LENGTH_SHORT).show()
        }
        txt_withdraw.setOnClickListener {
            try {
                val text = "withdraw request money" // Replace with your message.
                //    String toNumber = "xxxxxxxxxx"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
                //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=" +"917741930690"+"&text")
                startActivity(intent)
            } catch (e: Exception) {

                Toast.makeText(activity,"install whatsapp: "+e.printStackTrace().toString(),Toast.LENGTH_SHORT).show()

                var intent=Intent()
                var url="https://play.google.com/store/apps/details?id=com.whatsapp"
                intent.action=Intent.ACTION_VIEW
                intent.data=Uri.parse(url)
                startActivity(intent)
            }
        }

        btn_add.setOnClickListener {
            try {
                val text = "please add money" // Replace with your message.
                //    String toNumber = "xxxxxxxxxx"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
                //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=" +"917741930690"+"&text")
                startActivity(intent)
            } catch (e: Exception) {

                Toast.makeText(activity,"install whatsapp: "+e.printStackTrace().toString(),Toast.LENGTH_SHORT).show()

                var intent=Intent()
                var url="https://play.google.com/store/apps/details?id=com.whatsapp"
                intent.action=Intent.ACTION_VIEW
                intent.data=Uri.parse(url)
                startActivity(intent)
            }
        }
        return view
    }
}