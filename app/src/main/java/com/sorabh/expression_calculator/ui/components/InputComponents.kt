package com.sorabh.expression_calculator.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpressionInputFiled(
    modifier: Modifier,
    expression: String,
    onExpressionChanged: (String) -> Unit
) {
    OutlinedTextField(value = expression, onValueChange = onExpressionChanged, modifier = modifier)
}