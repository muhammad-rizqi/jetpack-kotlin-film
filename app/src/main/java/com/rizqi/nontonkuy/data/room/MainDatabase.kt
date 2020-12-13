package com.rizqi.nontonkuy.data.room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv

@Database(entities = [Movie::class, Tv::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun mainDao(): MainDao

    companion object {

        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase {
            if (INSTANCE == null) {
                synchronized(MainDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                MainDatabase::class.java, "Nonton.db")
                                .build()
                    }
                }
            }
            return INSTANCE as MainDatabase
        }
    }
}