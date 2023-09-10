package com.sorabh.expression_calculator.data.repo

import com.sorabh.expression_calculator.data.api.Result
import com.sorabh.expression_calculator.data.model.ExpressionRequest
import com.sorabh.expression_calculator.data.model.ExpressionResult
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    suspend fun evaluateExpression(expressionBody: ExpressionRequest): Flow<Result<ExpressionResult>>
}