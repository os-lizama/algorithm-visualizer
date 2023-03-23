package com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.oscarlizama.algorithmvisualizer.presentation.navigation.ALGORITHMS_ROUTE
import com.oscarlizama.algorithmvisualizer.presentation.navigation.Screen

fun NavGraphBuilder.algorithmsNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.InsertionSortScreen.route,
        route = ALGORITHMS_ROUTE
    ) {

    }
}