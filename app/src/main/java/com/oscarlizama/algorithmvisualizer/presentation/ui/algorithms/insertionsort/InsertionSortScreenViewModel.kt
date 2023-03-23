package com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.insertionsort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscarlizama.data.algorithms.insertionsort.InsertionSort
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.insertionsort.InsertionSortScreenViewModel.UIEvent.OnStart
import com.oscarlizama.algorithmvisualizer.presentation.util.AlgorithmEvents
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InsertionSortScreenViewModel(
    private val insertionSort: InsertionSort
) : ViewModel() {

    var uiState: UIState = UIState()
        private set

    private fun onStart() {
        uiState = uiState.copy(
            arr = listOf(100, 120, 80, 55, 40, 5, 25, 320, 80, 23, 534, 64)
        )
        onSortArray()
    }

    private fun onSortArray() {
        viewModelScope.launch {
            insertionSort.sort(
                arr = uiState.arr.toIntArray()
            ) { modifiedArray ->
                uiState = uiState.copy(
                    sortedArrayLevels = uiState.sortedArrayLevels + modifiedArray.toList()
                )
            }
        }
    }

    private fun onAlgorithmEvent(algorithmEvent: AlgorithmEvents) {
        when (algorithmEvent) {
            is AlgorithmEvents.PlayPause -> {
                playPauseAlgorithm()
            }
            is AlgorithmEvents.SlowDown -> {
                slowDownAlgorithm()
            }
            is AlgorithmEvents.SpeedUp -> {
                speedUpAlgorithm()
            }
            is AlgorithmEvents.Previous -> {
                algorithmPreviousStep()
            }
            is AlgorithmEvents.Next -> {
                algorithmNextStep()
            }
        }
    }

    private fun algorithmNextStep() {
        TODO("Not yet implemented")
    }

    private fun algorithmPreviousStep() {
        TODO("Not yet implemented")
    }

    private fun speedUpAlgorithm() {
        TODO("Not yet implemented")
    }

    private fun slowDownAlgorithm() {
        TODO("Not yet implemented")
    }

    private fun playPauseAlgorithm() {
        if (uiState.isPlaying)
            pauseAlgorithm()
        else
            playAlgorithm()
        uiState = uiState.copy(isPlaying = uiState.isPlaying.not())
    }

    private fun playAlgorithm() = viewModelScope.launch {
        uiState = uiState.copy(pause = false)
        for (i in 0 until uiState.sortedArrayLevels.size) {
            if (!uiState.pause) {
                delay(uiState.delay)
                uiState = uiState.copy(
                    arr = listOf(uiState.sortedArrayLevels[i])
                )
            } else {
                uiState = uiState.copy(sortingState = i)
                return@launch
            }
        }
        uiState = uiState.copy(
            onSortingFinished = true
        )
    }

    private fun pauseAlgorithm() {
        uiState = uiState.copy(pause = true)
    }

    fun onUiEvent(uiEvent: UIEvent) {
        when (uiEvent) {
            is OnStart -> onStart()
            is UIEvent.OnAlgorithmEvent -> onAlgorithmEvent(algorithmEvent = uiEvent.algorithmEvent)
        }
    }

    sealed class UIEvent() {
        object OnStart : UIEvent()
        data class OnAlgorithmEvent(val algorithmEvent: AlgorithmEvents) : UIEvent()
    }

    data class UIState(
        val arr: List<Int> = emptyList(),
        val isPlaying: Boolean = false,
        val pause: Boolean = false,
        val sortingState: Int = 0,
        val onSortingFinished: Boolean = false,
        val delay: Long = 150L,
        val sortedArrayLevels: List<Int> = emptyList()
    )

}