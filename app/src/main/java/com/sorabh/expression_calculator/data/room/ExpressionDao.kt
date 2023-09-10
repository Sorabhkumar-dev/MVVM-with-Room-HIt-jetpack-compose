package com.sorabh.expression_calculator.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sorabh.expression_calculator.data.model.Expression
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpressionDao {

    @Insert
    suspend fun insertExpressionData(expression: Expression)


    @Query("SELECT * FROM EXPRESSION_HISTORY")
    fun getAllExpressionData():Flow<List<Expression>>
}