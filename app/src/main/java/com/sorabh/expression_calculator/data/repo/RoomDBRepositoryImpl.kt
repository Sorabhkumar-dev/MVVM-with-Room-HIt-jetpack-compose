package com.sorabh.expression_calculator.data.repo

import com.sorabh.expression_calculator.data.model.Expression
import com.sorabh.expression_calculator.data.room.ExpressionDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomDBRepositoryImpl @Inject constructor(private val expressionDao: ExpressionDao) :
    RoomDBRepository {
    override suspend fun insertExpressionData(expression: Expression) =
        expressionDao.insertExpressionData(expression)

    override fun getAllExpressionData(): Flow<List<Expression>> =
        expressionDao.getAllExpressionData()
}