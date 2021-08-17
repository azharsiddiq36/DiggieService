package com.example.diggieservice.model.jual

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jual (
    val kode : Int,
    val result : ArrayList<Result>
):Parcelable