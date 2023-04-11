package com.oscarlizama.algorithmvisualizer.presentation.ui.home

import com.oscarlizama.algorithmvisualizer.presentation.base.BaseViewModel
import com.oscarlizama.algorithmvisualizer.presentation.navigation.Screen
import com.oscarlizama.algorithmvisualizer.presentation.util.SortingAlgorithm
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    val algorithms = SortingAlgorithm.values()

    private fun onNavigateToAlgorithmVisualizer(sortingAlgorithm: SortingAlgorithm) {
        navigateTo(
            "${Screen.AlgorithmVisualizerScreen.baseRoute}/$sortingAlgorithm"
        )
    }

    fun onUIEvent(uiEvent: UIEvent) {
        when (uiEvent) {
            is UIEvent.OnNavigateToAlgorithmVisualizer -> onNavigateToAlgorithmVisualizer(uiEvent.sortingAlgorithm)
        }
    }

    sealed class UIEvent {
        data class OnNavigateToAlgorithmVisualizer(val sortingAlgorithm: SortingAlgorithm) : UIEvent()
    }

}