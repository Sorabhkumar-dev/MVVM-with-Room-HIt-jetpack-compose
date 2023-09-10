package com.sorabh.expression_calculator.data.api

import com.sorabh.expression_calculator.data.model.ExpressionRequest
import com.sorabh.expression_calculator.data.model.ExpressionResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("v4/")
    suspend fun evaluateExpression(@Body expressionBody: ExpressionRequest): Response<ExpressionResult>
}