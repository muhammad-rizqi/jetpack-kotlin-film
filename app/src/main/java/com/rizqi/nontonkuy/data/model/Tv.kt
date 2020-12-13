package com.rizqi.nontonkuy.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tvs")
@Parcelize
data class Tv (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int,

    @ColumnInfo(name = "name")
    val name : String,

    @ColumnInfo(name = "popularity")
    val popularity : Double,

    @ColumnInfo(name = "vote_count")
    val vote_count : Int,

    @ColumnInfo(name = "first_air_date")
    val first_air_date : String,

    @ColumnInfo(name = "backdrop_path")
    val backdrop_path : String,

    @ColumnInfo(name = "vote_average")
    val vote_average : Double,

    @ColumnInfo(name = "overview")
    val overview : String,

    @ColumnInfo(name = "poster_path")
    val poster_path : String,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false
): Parcelable