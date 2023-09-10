package com.sorabh.expression_calculator.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sorabh.expression_calculator.ui.screens.caluculator.ExpressionCalculator
import com.sorabh.expression_calculator.ui.screens.caluculator.ExpressionCalculatorViewModel
import com.sorabh.expression_calculator.ui.screens.history.ExpressionHistory
import com.sorabh.expression_calculator.ui.screens.history.ExpressionHistoryViewModel

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = ScreenNavigator.ExpressionCalculatorScreen.name
    ) {
        composable(ScreenNavigator.ExpressionCalculatorScreen.name){
            val viewModel = hiltViewModel<ExpressionCalculatorViewModel>()
            ExpressionCalculator(viewModel = viewModel,navController = navController)
        }

        composable(ScreenNavigator.ExpressionHistoryScreen.name){
            val viewModel = hiltViewModel<ExpressionHistoryViewModel>()
            ExpressionHistory(viewModel = viewModel,navController = navController)
        }
    }
}