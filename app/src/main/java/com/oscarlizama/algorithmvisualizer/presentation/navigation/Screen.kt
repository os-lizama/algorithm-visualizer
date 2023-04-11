package com.oscarlizama.algorithmvisualizer.presentation.navigation

const val ALGORITHMS_ROUTE = "algorithms_route"
const val HOME_ROUTE = "home_route"
const val ALGORITHM_IDENTIFIER = "algorithm_identifier"

sealed class Screen(val route: String, val baseRoute: String = "") {
    // Home Screen
    object HomeScreen : Screen("home_screen")

    // Algorithm NavGraph
    object AlgorithmVisualizerScreen : Screen(
        "algorithm_visualizer_screen/{$ALGORITHM_IDENTIFIER}",
        "algorithm_visualizer_screen"
    )
}