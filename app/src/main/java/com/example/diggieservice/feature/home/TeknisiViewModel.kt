package com.example.diggieservice.feature.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diggieservice.enum.Constant
import com.example.diggieservice.model.teknisi.Teknisi
import com.example.diggieservice.repository.TeknisiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class TeknisiViewModel
@Inject constructor(private val teknisiRepository:TeknisiRepository):ViewModel() {
    private val teknisi = MutableLiveData<Teknisi>()

    fun getTechnicanAll(param:String,order:String):LiveData<Teknisi>?{
        viewModelScope.launch {
            teknisiRepository.getTechnicianAll(param,order).let { response->
                response.enqueue(object :Callback<Teknisi>{
                    override fun onResponse(call: Call<Teknisi>, response: Response<Teknisi>) {
                        val data = response.body()
                        teknisi!!.value = data
                        Log.d(Constant.FINDBUG, "onResponse: $data")
                    }

                    override fun onFailure(call: Call<Teknisi>, t: Throwable) {
                        Log.d(Constant.FINDBUG, "onResponse: $t")
                    }

                })
            }
        }
        return teknisi
    }

}