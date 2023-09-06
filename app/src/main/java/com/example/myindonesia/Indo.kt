package com.example.myindonesia

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Indo(
    val name: String,
    val description: String,
    val photo: Int,
    val cost: String,  // Tambahkan informasi biaya
    val accommodation: String,  // Tambahkan informasi akomodasi
    val food: String  // Tambahkan informasi makanan
) : Parcelable

