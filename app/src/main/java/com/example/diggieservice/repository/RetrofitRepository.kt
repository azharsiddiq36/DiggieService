package com.example.rdiandroiddevelopertest.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.diggieservice.enum.Constant
import com.example.rdiandroiddevelopertest.api.DigieServiceClient
import com.example.rdiandroiddevelopertest.model.Author
import com.example.rdiandroiddevelopertest.model.Genre
import com.example.rdiandroiddevelopertest.model.ItemsMovie
import com.example.rdiandroiddevelopertest.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRepository(context: Context) {
    private val responseGenre = MutableLiveData<Genre>()
    private val responseMovie = MutableLiveData<Movie>()
    private val responseDetailsMovie = MutableLiveData<ItemsMovie>()
    private val responseReviewMovie = MutableLiveData<Author>()

    fun getResponseReviewMovie(movieId: String, page: Int): MutableLiveData<Author> {
        val call = DigieServiceClient.DIGIE_SERVICE_INTERFACE.getReviewMovie(
            movieId,
            Constant.API_KEY,
            Constant.LANGUAGE,
            page
        )
        call.enqueue(object : Callback<Author> {
            override fun onResponse(call: Call<Author>, response: Response<Author>) {
                val data = response.body()
                responseReviewMovie.value = data!!
            }

            override fun onFailure(call: Call<Author>, t: Throwable) {
                Log.d(Constant.FINDBUG, "RetrofitRepository onResponse: $t")
            }

        })
        return responseReviewMovie
    }

    fun percobaan() {
        println("Perocbaan Pertama")
    }

}