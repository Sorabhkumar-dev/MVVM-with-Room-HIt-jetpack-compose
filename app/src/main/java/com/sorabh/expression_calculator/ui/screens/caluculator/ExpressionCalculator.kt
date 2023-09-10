package com.sorabh.expression_calculator.ui.screens.caluculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sorabh.expression_calculator.R
import com.sorabh.expression_calculator.data.api.Result
import com.sorabh.expression_calculator.ui.components.ExpressionInputFiled
import com.sorabh.expression_calculator.ui.screens.navigation.ScreenNavigator

@Composable
fun ExpressionCalculator(viewModel: ExpressionCalculatorViewModel, navController: NavController) {
    val expressionResult = viewModel.expressionResultFlow.collectAsStateWithLifecycle(null).value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.heightIn(16.dp))

            Box(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = stringResource(id = R.string.enter_your_expression_to_evaluate),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.align(Alignment.CenterStart)
                )

                FloatingActionButton(
                    onClick = { navController.navigate(ScreenNavigator.ExpressionHistoryScreen.name) },
                    shape = CircleShape,
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription = "history")
                }

            }
            Spacer(modifier = Modifier.heightIn(16.dp))

            ExpressionInputFiled(
                modifier = Modifier.fillMaxWidth(),
                expression = viewModel.expressionFlow.collectAsStateWithLifecycle().value,
                onExpressionChanged = viewModel::onExpressionChanged
            )
            Spacer(modifier = Modifier.heightIn(16.dp))

            Button(
                onClick = viewModel::evaluateExpression,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.evaluate_expression),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.heightIn(34.dp))
        }

        when (expressionResult) {
            is Result.Error -> item {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Error icon",
                    modifier = Modifier.size(50.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.heightIn(16.dp))
                Text(
                    text = stringResource(id = R.string.something_went_wrong),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            is Result.Loading -> item {
                Text(
                    text = stringResource(id = R.string.evaluating_expression),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.heightIn(16.dp))

                CircularProgressIndicator(modifier = Modifier.size(50.dp))
            }

            is Result.Success -> expressionResult.body?.result?.let {
                itemsIndexed(it) { index, item ->
                    Text(
                        text = "Expression ${index + 1} Result -> $item",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.heightIn(8.dp))
                    Divider(modifier = Modifier.fillMaxWidth())
                }

            } ?: item {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Error icon",
                    modifier = Modifier.size(50.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.heightIn(16.dp))
                Text(
                    text = stringResource(id = R.string.no_result_found),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            else -> {}
        }

    }
}

