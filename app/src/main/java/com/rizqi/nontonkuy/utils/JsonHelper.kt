package com.rizqi.nontonkuy.utils

import android.content.Context
import com.google.gson.Gson
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import java.io.IOException

class JsonHelper(private val context: Context) {
  private var gson = Gson()

  private fun parsingFileToString(fileName: String): String? {
    return try {
      val `is` = context.assets.open(fileName)
      val buffer = ByteArray(`is`.available())
      `is`.read(buffer)
      `is`.close()
      String(buffer)

    } catch (ex: IOException) {
      ex.printStackTrace()
      null
    }
  }

  fun loadTvs(): List<Tv> {
    return gson.fromJson(parsingFileToString("tvs.json").toString(), Array<Tv>::class.java).toList()
  }

  fun loadMovies(): List<Movie> {
    return gson.fromJson(parsingFileToString("movies.json").toString(), Array<Movie>::class.java)
      .toList()
  }

}