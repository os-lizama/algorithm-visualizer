package com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.oscarlizama.algorithmvisualizer.presentation.navigation.HOME_ROUTE
import com.oscarlizama.algorithmvisualizer.presentation.navigation.Screen
import com.oscarlizama.algorithmvisualizer.presentation.ui.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.HomeScreen.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                onNavigate = {
                    navController.navigate(it.route)
                },
            )
        }
    }
}