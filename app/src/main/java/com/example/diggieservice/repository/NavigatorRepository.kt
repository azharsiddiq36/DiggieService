package com.example.rdiandroiddevelopertest.repository

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.diggieservice.MainActivity
import com.example.diggieservice.enum.Constant.FINDBUG
import com.example.diggieservice.enum.Constant.JENIS
import com.example.diggieservice.enum.Constant.SELL
import com.example.diggieservice.enum.Constant.TERBARU
import com.example.diggieservice.feature.shop.activity.ListShopActivity
import com.example.diggieservice.feature.shop.activity.ShopDetailsAcitivity
import com.example.diggieservice.model.jual.Result


object NavigatorRepository {
//    fun openListMovieActivity(context: Context,genreId:String?){
//        val intent = Intent(context, MovieListActivity::class.java)
//        intent.putExtra(Constant.genreId,genreId)
//        context.startActivity(intent)
//    }
    fun openShopDetailsActivity(context: Context, jual: Result){
        val intent = Intent(context,ShopDetailsAcitivity::class.java)
        intent.putExtra(SELL,jual)
         Log.d(FINDBUG, "openShopDetailsActivity: 21"+jual.jual_judul)
        context.startActivity(intent)
    }
    fun openListShopActivity(context: Context,jenis:String){
        val intent = Intent(context,ListShopActivity::class.java)
        intent.putExtra(JENIS,jenis)
        context.startActivity(intent)
    }
    fun openMainActivity(context: Context){
        val intent = Intent(context,MainActivity::class.java)
        context.startActivity(intent)
    }
}