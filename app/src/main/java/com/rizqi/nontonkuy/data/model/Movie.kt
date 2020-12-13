package com.rizqi.nontonkuy.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movies")
@Parcelize
data class Movie (
  @PrimaryKey
  @ColumnInfo(name = "id")
  var id: Int,

  @ColumnInfo(name = "poster_path")
  var poster_path: String,

  @ColumnInfo(name = "original_title")
  var original_title: String,

  @ColumnInfo(name = "vote_average")
  var vote_average: Double,

  @ColumnInfo(name = "overview")
  var overview: String,

  @ColumnInfo(name = "release_date")
  var release_date: String,
): Parcelable
