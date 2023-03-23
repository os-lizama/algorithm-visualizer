package com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.oscarlizama.algorithmvisualizer.presentation.navigation.ALGORITHMS_ROUTE

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ALGORITHMS_ROUTE
    ) {
        algorithmsNavGraph(navController = navController)
    }
}