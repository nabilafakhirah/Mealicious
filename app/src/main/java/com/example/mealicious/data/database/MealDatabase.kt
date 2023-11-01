package com.example.mealicious.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mealicious.data.dao.MealDao
import com.example.mealicious.data.model.entity.MealEntity
import com.example.mealicious.util.ListConverter

@Database(
    entities = [MealEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class MealDatabase : RoomDatabase() {
    abstract val mealDao: MealDao
}