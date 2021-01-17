package com.tech.onlinematka.ui.result

import android.app.DownloadManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech.onlinematka.MatkaService
import com.tech.onlinematka.adapter.MyRecyclerViewAdapter
import com.tech.onlinematka.R
import com.tech.onlinematka.data.Entry
import com.tech.onlinematka.data.Feed
import com.tech.onlinematka.model.Matka
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultFragment : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyleViewMarket: RecyclerView
    private lateinit var myRecyclerViewAdapter: MyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.fragment_result, container, false)
        recyleViewMarket = view.findViewById(R.id.recycle_view_market)




        getNews()

        var list_matka = mutableListOf<Matka>(
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated"),
            Matka("1.11", "2.22", "kalyan matka", "152 22 454", "updated")


        )

        recyleViewMarket.layoutManager = LinearLayoutManager(requireContext())

        myRecyclerViewAdapter= MyRecyclerViewAdapter(requireContext(), list_matka, this)

        recyleViewMarket.adapter=myRecyclerViewAdapter




        return view
    }


    private fun getNews() {



        val news = MatkaService.newsInstance.getHeadlines()

        news.enqueue(object : Callback<Feed> {
            override fun onFailure(call: Call<Feed>, t: Throwable) {
               Toast.makeText(activity,"error in fetching data",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {

                val mynews = response.body()

                if (mynews != null) {

////                    totalResults = mynews.totalResults    //will get total count here
////                    cate.addAll(mynews.articles)
//                    myRecyclerViewAdapter.notifyDataSetChanged()

              Log.d("response",mynews.toString())

                } else {

                    Toast.makeText(activity,"null response",Toast.LENGTH_SHORT).show()

                }
            }

        })
    }


}