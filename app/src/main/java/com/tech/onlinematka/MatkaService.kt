package com.tech.onlinematka



import com.tech.onlinematka.data.Entry
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query



//https://spreadsheets.google.com/feeds/cells/1FXKAsf6Y0YcJz-Aq0ZoaHxUtBdUkviOCaAkI9IXdfbk/od6/public/full?alt=json
const val BASE_URL = "https://spreadsheets.google.com"
//const val API_KEY = "2357eef173f14e15bf0e7e14cb872630"

interface NewsInterface {

    // @GET("top-headlines?country=in&category=entertainment&sortBy=popularity\n" +
    // "&apiKey=2357eef173f14e15bf0e7e14cb872630")

    @GET("feeds/cells/1FXKAsf6Y0YcJz-Aq0ZoaHxUtBdUkviOCaAkI9IXdfbk/od6/public/full?alt=jsonfeeds/cells/1FXKAsf6Y0YcJz-Aq0ZoaHxUtBdUkviOCaAkI9IXdfbk/od6/public/full?alt=json")
    fun getHeadlines(): Call<Entry>


}

object MatkaService {
    val newsInstance: NewsInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}