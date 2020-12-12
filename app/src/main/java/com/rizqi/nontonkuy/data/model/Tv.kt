package com.rizqi.nontonkuy.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tv (
    val id : Int,
    val name : String,
    val popularity : Double,
    val vote_count : Int,
    val first_air_date : String,
    val backdrop_path : String,
    val vote_average : Double,
    val overview : String,
    val poster_path : String
): Parcelable