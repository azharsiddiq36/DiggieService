package com.example.diggieservice.model.teknisi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Teknisi (
    val kode: Int,
    val result: ArrayList<Result>
):Parcelable