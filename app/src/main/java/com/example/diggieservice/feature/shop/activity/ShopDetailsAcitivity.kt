package com.example.diggieservice.feature.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diggieservice.databinding.ActivityShopDetailsAcitivityBinding
import com.example.diggieservice.enum.Constant.SELL
import com.example.diggieservice.lib.PictureLib
import com.example.diggieservice.lib.PictureLib.loadPicture
import com.example.diggieservice.model.jual.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopDetailsAcitivity : AppCompatActivity() {
    private lateinit var _binding:ActivityShopDetailsAcitivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        _binding = ActivityShopDetailsAcitivityBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val item = intent.getParcelableExtra<Result>(SELL)
        _binding.tvTitle.text = item?.jual_judul
        _binding.tvPrice.text = "Rp. ${item?.jual_harga}"
        val rating = item?.teknisi_total_score?.div(item?.teknisi_total_responden!!)
        _binding.tvRating.text = String.format("%.1f", (rating)).toDouble().toString()
        _binding.rbRating.rating = rating!!.toFloat()
        loadPicture(this,item.teknisi_foto,_binding.ivImageProduct)
    }
}