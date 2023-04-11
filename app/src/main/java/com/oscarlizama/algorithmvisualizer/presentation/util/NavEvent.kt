package com.oscarlizama.algorithmvisualizer.presentation.util

sealed class NavEvent {
    data class PopBackStack(val popTo: String) : NavEvent()
    data class Navigate(val route: String) : NavEvent()
    data class PopAndNavigateTo(val route: String, val popTo: String) : NavEvent()
}