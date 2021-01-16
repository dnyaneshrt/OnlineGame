package com.tech.onlinematka.adapter

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.tech.onlinematka.HomeScreenActivity
import com.tech.onlinematka.R
import com.tech.onlinematka.data.Entry
import com.tech.onlinematka.model.Matka
import com.tech.onlinematka.ui.*
import com.tech.onlinematka.ui.result.ResultFragment

class MyRecyclerViewAdapter(
    var requireContext: Context,
    var list_matka: MutableList<Matka>,
    var resultFragment: ResultFragment
) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.my_market_view, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {




//        holder.text_open_time.text = list.open_time
//        holder.text_close_time.text = list.close_time
//        holder.text_matka_name.text = list.matka_name
//        holder.text_matka_result.text = list.result_number
//        holder.text_betting_update.text = list.betting_updateString

        holder.button_play.setOnClickListener {
            Toast.makeText(requireContext, "play button clicked", Toast.LENGTH_SHORT).show()
            showDialog()

        }
    }

    override fun getItemCount(): Int {
        return list_matka.size
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text_open_time = itemView.findViewById<TextView>(R.id.text_open_time)

        var text_close_time = itemView.findViewById<TextView>(R.id.text_close_time)

        var text_matka_name = itemView.findViewById<TextView>(R.id.text_market_name)

        var text_matka_result = itemView.findViewById<TextView>(R.id.text_result_number)

        var text_betting_update = itemView.findViewById<TextView>(R.id.text_betting_update)

        var button_play = itemView.findViewById<Button>(R.id.button_play)
    }

    fun showDialog() {
        var dialog = Dialog(requireContext)
        dialog.setTitle("select:")
        dialog.setContentView(R.layout.select_your_game)
        dialog.show()

        var button_single_digit=dialog.findViewById<Button>(R.id.button_single_digit)
        var button_double_jodi=dialog.findViewById<Button>(R.id.button_double_digit)
        var button_single_pana=dialog.findViewById<Button>(R.id.button_single_pana)
        var button_double_pana=dialog.findViewById<Button>(R.id.button_double_pana)
        var button_triple_pana=dialog.findViewById<Button>(R.id.button_triple_pana)



        button_single_digit.setOnClickListener {
          showToast("single button")

            var intent= Intent(requireContext,SingleDigitActivity::class.java)
     requireContext.startActivity(intent)

              }

        button_double_jodi.setOnClickListener {
            showToast("double jodi button")

            var intent= Intent(requireContext, DoubleJodiActivity::class.java)
            requireContext.startActivity(intent)

        }

        button_single_pana.setOnClickListener {
            showToast("single pana button")
            var intent= Intent(requireContext, SinglePanaActivity::class.java)
            requireContext.startActivity(intent)


        }

        button_double_pana.setOnClickListener {
            showToast("double pana button")


            var intent= Intent(requireContext, DoublePanaActivity::class.java)
            requireContext.startActivity(intent)

        }

        button_triple_pana.setOnClickListener {
            showToast("triple pana  button")

            var intent= Intent(requireContext, TriplePanaActivity::class.java)
            requireContext.startActivity(intent)

        }


        var window = dialog.getWindow()
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
    }

    private fun showToast(s: String) {
Toast.makeText(requireContext,s,Toast.LENGTH_SHORT).show()
    }
}

