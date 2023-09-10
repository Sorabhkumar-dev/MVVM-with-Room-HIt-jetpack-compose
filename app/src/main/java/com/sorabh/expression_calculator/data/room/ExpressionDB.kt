package com.sorabh.expression_calculator.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sorabh.expression_calculator.data.model.Expression

@Database(entities = [Expression::class], version = 1)
@TypeConverters(LocalDateTimeConverter::class)
abstract class ExpressionDB : RoomDatabase() {
    abstract fun expressionDao(): ExpressionDao
}