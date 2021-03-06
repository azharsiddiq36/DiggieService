package com.example.diggieservice.model.jual

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result (
    val created_at: String,
    val jenis_id: Int,
    val jenis_nama: String,
    val jenis_thumbnail: String,
    val jual_deskripsi: String,
    val jual_foto: String,
    val jual_harga: Int,
    val jual_id: Int,
    val jual_jenis_hp: Int,
    val jual_judul: String,
    val jual_status: String,
    val jual_tgl_penjualan: String,
    val jual_tujuan: String,
    val jual_user_id: Int,
    val teknisi_alamat: String,
    val teknisi_deskripsi: String,
    val teknisi_foto: String,
    val teknisi_hp: String,
    val teknisi_id: Int,
    val teknisi_lat: String,
    val teknisi_lng: String,
    val teknisi_nama: String,
    val teknisi_sertifikat: String,
    val teknisi_total_responden: Double,
    val teknisi_total_score: Double,
    val updated_at: String
):Parcelable