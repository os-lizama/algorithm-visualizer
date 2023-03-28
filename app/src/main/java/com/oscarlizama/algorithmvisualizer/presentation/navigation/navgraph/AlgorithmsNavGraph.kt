package com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.oscarlizama.algorithmvisualizer.presentation.navigation.ALGORITHMS_ROUTE
import com.oscarlizama.algorithmvisualizer.presentation.navigation.Screen
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.insertionsort.InsertionSortScreen

fun NavGraphBuilder.algorithmsNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.InsertionSortScreen.route,
        route = ALGORITHMS_ROUTE
    ) {
        composable(
            route = Screen.InsertionSortScreen.route
        ) {
            InsertionSortScreen()
        }
    }
}