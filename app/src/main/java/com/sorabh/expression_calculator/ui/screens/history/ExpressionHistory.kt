package com.sorabh.expression_calculator.ui.screens.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sorabh.expression_calculator.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun ExpressionHistory(viewModel: ExpressionHistoryViewModel, navController: NavController) {
    val expressionHistoryFlow = viewModel.expressionHistoryFlow.collectAsStateWithLifecycle().value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.heightIn(16.dp))
            Text(
                text = stringResource(id = R.string.expression_evaluation_history),
                style = MaterialTheme.typography.titleMedium
            )

        }

        if (expressionHistoryFlow.isEmpty())
            item {
                Spacer(modifier = Modifier.heightIn(16.dp))
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
        else
            items(expressionHistoryFlow) { expression ->
                Text(
                    text = "Expression: ${expression.expression}     =>  Result: ${expression.result}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.heightIn(8.dp))
                Text(
                    text = "Date: ${expression.date.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"))}",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.heightIn(8.dp))
                Divider(modifier = Modifier.fillMaxWidth())

            }

    }
}