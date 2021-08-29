package com.example.diggieservice.feature.shop.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.diggieservice.databinding.ActivityShopDetailsAcitivityBinding
import com.example.diggieservice.enum.Constant.SELL
import com.example.diggieservice.lib.PictureLib
import com.example.diggieservice.lib.PictureLib.loadPicture
import com.example.diggieservice.lib.Tools
import com.example.diggieservice.lib.ViewAnimation
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
        _binding.btBack.setOnClickListener {
            onBackPressed()
        }
        _binding.btBuy.setOnClickListener {
//            toggleSection()
        }
        _binding.btToggleDescription.setOnClickListener{
            toggleSection(it,_binding.lytExpandDescription)
        }

        // expand first description
        toggleArrow(_binding.btToggleDescription)
        _binding.lytExpandDescription.setVisibility(View.VISIBLE)
        if (item.teknisi_sertifikat == null){
            _binding.ivSertifikat.visibility = View.GONE
            _binding.tvSertifikat.visibility = View.VISIBLE
        }else{
            _binding.ivSertifikat.visibility = View.VISIBLE
            loadPicture(this,item.teknisi_sertifikat,_binding.ivSertifikat)
        }
    }
    private fun toggleSection(bt: View, lyt: View) {
        val show = toggleArrow(bt)
        if (show) {
            ViewAnimation.expand(lyt, object : ViewAnimation.AnimListener {
                override fun onFinish() {
                    Tools.nestedScrollTo(_binding.nestedScrollView, lyt)
                }
            })
        } else {
            ViewAnimation.collapse(lyt)
        }
    }
    fun toggleArrow(view: View): Boolean {
        return if (view.rotation == 0f) {
            view.animate().setDuration(200).rotation(180f)
            true
        } else {
            view.animate().setDuration(200).rotation(0f)
            false
        }
    }
}