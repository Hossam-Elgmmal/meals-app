package com.route.mealsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.mealsapp.model.MealItem

@Database(entities = [MealItem::class], version = 1)
abstract class MealDatabase : RoomDatabase() {

    abstract fun getDao(): MealsDao

    companion object {
        private const val DATABASE_NAME = "meals"
        private var INSTANCE: MealDatabase? = null
        fun init(context: Context) {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, MealDatabase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
            }
        }

        fun getInstance(): MealDatabase {
            return INSTANCE!!
        }

    }
}