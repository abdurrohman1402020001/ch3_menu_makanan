package com.chalange3_menu_makanan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(val image: Int,
                val name: String,
                val price: String,
                val description: String,
                val location: String ):Parcelable
