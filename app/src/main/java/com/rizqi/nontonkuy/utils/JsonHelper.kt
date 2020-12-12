package com.rizqi.nontonkuy.utils

import android.content.Context
import com.google.gson.Gson
import com.rizqi.nontonkuy.data.model.Movies
import com.rizqi.nontonkuy.data.model.Tvs
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

  fun loadTvs(): Tvs {
    return gson.fromJson(parsingFileToString("tvs.json").toString(), Tvs::class.java)
  }

  fun loadMovies(): Movies {
    return gson.fromJson(parsingFileToString("movies.json").toString(), Movies::class.java)
  }

}