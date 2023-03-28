package com.oscarlizama.algorithmvisualizer.presentation.navigation

const val ALGORITHMS_ROUTE = "algorithms_route"

sealed class Screen(val route: String, val baseRoute: String = "") {
    // Algorithm NavGraph
    object InsertionSortScreen : Screen("insertion_sort_screen")
}