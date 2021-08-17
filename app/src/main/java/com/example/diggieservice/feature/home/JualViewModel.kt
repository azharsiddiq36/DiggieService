package com.example.diggieservice.feature.home

import android.util.Log
import androidx.lifecycle.*
import com.example.diggieservice.enum.Constant
import com.example.diggieservice.lib.PictureLib
import com.example.diggieservice.model.jual.Jual
import com.example.rdiandroiddevelopertest.repository.JualRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class JualViewModel
@Inject constructor(
    private val jualRepository: JualRepository
): ViewModel(){

    private val jual = MutableLiveData<Jual>()

    fun getJualAll(cus:String,order:String):LiveData<Jual>?{
        viewModelScope.launch {
            jualRepository.getSellAll(cus,order).let {response->
                response.enqueue(object : Callback<Jual> {
                    override fun onResponse(call: Call<Jual>, response: Response<Jual>) {
                        val data = response.body()
                        jual!!.value = data
                        Log.d(Constant.FINDBUG, "onResponse: kentang viewmodel 37 "+jual)
                    }

                    override fun onFailure(call: Call<Jual>, t: Throwable) {
                        Log.d(Constant.FINDBUG, "JualViewModel onResponse: $t")
                    }

                })
            }
        }
        return jual
    }
//    fun getPict() = pictLib
}