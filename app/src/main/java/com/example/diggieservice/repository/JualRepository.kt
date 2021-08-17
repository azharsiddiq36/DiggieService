package com.example.rdiandroiddevelopertest.repository

import com.example.diggieservice.enum.Constant.CUSTOMER
import com.example.diggieservice.enum.Constant.DESC
import com.example.rdiandroiddevelopertest.api.DigieServiceInterface
import javax.inject.Inject

class JualRepository
@Inject
constructor(private val digieServiceInterface: DigieServiceInterface) {
//    private val responseGenre = MutableLiveData<Genre>()
//    private val responseMovie = MutableLiveData<Movie>()
//    private val responseDetailsMovie = MutableLiveData<ItemsMovie>()
//    private val responseReviewMovie = MutableLiveData<Author>()
//    private val responseJualAll = MutableLiveData<Jual>()

//    fun getResponseReviewMovie(movieId: String, page: Int): MutableLiveData<Author> {
//        val call = diggieServiceClient.DIGIE_SERVICE_INTERFACE.getReviewMovie(
//            movieId,
//            Constant.API_KEY,
//            Constant.LANGUAGE,
//            page
//        )
//        call.enqueue(object : Callback<Author> {
//            override fun onResponse(call: Call<Author>, response: Response<Author>) {
//                val data = response.body()
//                responseReviewMovie.value = data!!
//            }
//
//            override fun onFailure(call: Call<Author>, t: Throwable) {
//                Log.d(Constant.FINDBUG, "RetrofitRepository onResponse: $t")
//            }
//
//        })
//        return responseReviewMovie
//    }
    fun getSellAll(cus:String,order:String) = digieServiceInterface.getJual(cus, order)
//    fun getJualAll():MutableLiveData<Jual>{
//        val call = DigieServiceClient.DIGIE_SERVICE_INTERFACE.getJual()
//        call.enqueue(object : Callback<Jual>{
//            override fun onResponse(call: Call<Jual>, response: Response<Jual>) {
//                val data = response.body()
//                responseJualAll.value = data!!
//            }
//
//            override fun onFailure(call: Call<Jual>, t: Throwable) {
//                Log.d(Constant.FINDBUG, "JualRepository onResponse: $t")
//            }
//
//        })
//        return responseJualAll
//    }

}