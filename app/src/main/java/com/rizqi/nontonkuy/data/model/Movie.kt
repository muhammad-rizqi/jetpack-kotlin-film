package com.rizqi.nontonkuy.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var id: Int,
    var poster_path: String,
    var original_title: String,
    var vote_average: Double,
    var overview: String,
    var release_date: String,
): Parcelable
