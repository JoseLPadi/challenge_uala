package com.example.challengeuala.repository.data_store

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.challengeuala.repository.data_store.daos.CityDAO
import com.example.challengeuala.repository.entities.City

@Database(entities = [City::class], version = 4, exportSchema = false)
@TypeConverters(CoordConverter::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun cityDao(): CityDAO
    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getDatabase(context: Context, coordConverter: CoordConverter): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "item_database"
                )
                    .addTypeConverter(coordConverter)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}