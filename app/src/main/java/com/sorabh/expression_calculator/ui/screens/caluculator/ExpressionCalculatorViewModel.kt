package com.sorabh.expression_calculator.ui.screens.caluculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.expression_calculator.data.api.Result
import com.sorabh.expression_calculator.data.model.Expression
import com.sorabh.expression_calculator.data.model.ExpressionRequest
import com.sorabh.expression_calculator.data.model.ExpressionResult
import com.sorabh.expression_calculator.data.repo.NetworkRepository
import com.sorabh.expression_calculator.data.repo.RoomDBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpressionCalculatorViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val roomDBRepository: RoomDBRepository
) : ViewModel() {

    private val _expressionResultFlow: MutableSharedFlow<Result<ExpressionResult>> =
        MutableSharedFlow()
    val expressionResultFlow = _expressionResultFlow.asSharedFlow()

    val expressionFlow = MutableStateFlow("")

    fun onExpressionChanged(expression: String) {
        expressionFlow.value = expression
    }

    fun evaluateExpression() {
        viewModelScope.launch {
            _expressionResultFlow.emit(Result.Loading(true))
            val expressions = expressionFlow.value.split("\n").toList()
            networkRepository.evaluateExpression(
                ExpressionRequest(expressions, null)
            ).collect {
                _expressionResultFlow.emit(it)
                if (it is Result.Success) {
                    expressions.forEachIndexed { index, expression ->
                        roomDBRepository.insertExpressionData(
                            Expression(0, expression, it.body?.result?.get(index) ?: "")
                        )
                    }

                }
            }
        }
    }

}