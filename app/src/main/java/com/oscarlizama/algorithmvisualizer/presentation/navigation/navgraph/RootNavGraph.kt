package com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.oscarlizama.algorithmvisualizer.presentation.navigation.HOME_ROUTE

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        homeNavGraph(navController = navController)
        algorithmsNavGraph(navController = navController)
    }
}