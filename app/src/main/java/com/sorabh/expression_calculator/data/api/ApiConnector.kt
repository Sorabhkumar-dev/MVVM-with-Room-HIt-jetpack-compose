package com.sorabh.expression_calculator.data.api

import com.sorabh.expression_calculator.data.model.ExpressionRequest
import com.sorabh.expression_calculator.data.model.ExpressionResult
import kotlinx.coroutines.flow.Flow

interface ApiConnector {
    suspend fun evaluateExpression(expressionBody:ExpressionRequest):Flow<Result<ExpressionResult>>
}