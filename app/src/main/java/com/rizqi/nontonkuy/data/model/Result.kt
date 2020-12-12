package com.rizqi.nontonkuy.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    var results: ArrayList<Movie>
): Parcelable

data class  Tvs (
    var results: ArrayList<Tv>
)