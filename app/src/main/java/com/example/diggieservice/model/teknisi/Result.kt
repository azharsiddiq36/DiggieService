package com.example.diggieservice.model.teknisi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val created_at: String,
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
): Parcelable