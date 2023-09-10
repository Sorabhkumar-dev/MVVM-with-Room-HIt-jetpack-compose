package com.sorabh.expression_calculator.data.api

import com.sorabh.expression_calculator.data.model.ExpressionRequest
import com.sorabh.expression_calculator.data.model.ExpressionResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiConnectorImpl @Inject constructor(private val apiService: ApiService) : ApiConnector {
    override suspend fun evaluateExpression(expressionBody: ExpressionRequest): Flow<Result<ExpressionResult>> =
        flow {
            val apiResponse = apiService.evaluateExpression(expressionBody)
            if (apiResponse.isSuccessful)
                emit(Result.Success(apiResponse.code(),apiResponse.body()))
            else
                emit(Result.Error(apiResponse.code()))
        }
}