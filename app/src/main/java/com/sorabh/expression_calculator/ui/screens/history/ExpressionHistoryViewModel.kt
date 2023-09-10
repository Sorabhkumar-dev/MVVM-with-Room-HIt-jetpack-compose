package com.sorabh.expression_calculator.ui.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.expression_calculator.data.model.Expression
import com.sorabh.expression_calculator.data.repo.RoomDBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpressionHistoryViewModel @Inject constructor(private val roomDBRepository: RoomDBRepository) :
    ViewModel() {
        val expressionHistoryFlow:MutableStateFlow<List<Expression>> = MutableStateFlow(emptyList())

    init {
        getExpressionHistory()
    }

    private fun getExpressionHistory(){
        viewModelScope.launch {
            roomDBRepository.getAllExpressionData().collect{
                expressionHistoryFlow.value = it
            }
        }
    }
}