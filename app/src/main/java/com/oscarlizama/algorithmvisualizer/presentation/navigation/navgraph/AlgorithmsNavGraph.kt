package com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.oscarlizama.algorithmvisualizer.presentation.navigation.ALGORITHMS_ROUTE
import com.oscarlizama.algorithmvisualizer.presentation.navigation.ALGORITHM_IDENTIFIER
import com.oscarlizama.algorithmvisualizer.presentation.navigation.Screen
import com.oscarlizama.algorithmvisualizer.presentation.navigation.navtype.SortingAlgorithmNavType
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer.AlgorithmVisualizerScreen

fun NavGraphBuilder.algorithmsNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.AlgorithmVisualizerScreen.route,
        route = ALGORITHMS_ROUTE
    ) {
        composable(
            route = Screen.AlgorithmVisualizerScreen.route,
            arguments = listOf(
                navArgument(ALGORITHM_IDENTIFIER) { type = SortingAlgorithmNavType() }
            )
        ) {
            AlgorithmVisualizerScreen(
                onPopBackStack = {
                    navController.popBackStack(
                        route = it.popTo,
                        inclusive = false,
                        saveState = false
                    )
                }
            )
        }
    }
}