package com.sorabh.expression_calculator.data.api

sealed class Result<T>{

    data class Success<T>(val code:Int?,val body:T?):Result<T>()

    data class Error<T>(val code:Int?):Result<T>()

    data class Loading<T>(val isLoading:Boolean = true):Result<T>()

}
