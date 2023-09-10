package com.sorabh.expression_calculator.data.repo

import com.sorabh.expression_calculator.data.api.ApiConnector
import com.sorabh.expression_calculator.data.api.Result
import com.sorabh.expression_calculator.data.model.ExpressionRequest
import com.sorabh.expression_calculator.data.model.ExpressionResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val apiConnector: ApiConnector) :
    NetworkRepository {
    override suspend fun evaluateExpression(expressionBody: ExpressionRequest): Flow<Result<ExpressionResult>> =
        apiConnector.evaluateExpression(expressionBody)
}