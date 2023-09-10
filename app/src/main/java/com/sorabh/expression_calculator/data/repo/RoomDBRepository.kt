package com.sorabh.expression_calculator.data.repo

import com.sorabh.expression_calculator.data.model.Expression
import kotlinx.coroutines.flow.Flow

interface RoomDBRepository {

    suspend fun insertExpressionData(expression: Expression)

    fun getAllExpressionData(): Flow<List<Expression>>
}