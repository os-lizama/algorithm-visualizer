package com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscarlizama.domain.algorithms.insertionsort.InsertionSort
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnStart
import com.oscarlizama.algorithmvisualizer.presentation.util.AlgorithmEvents
import com.oscarlizama.algorithmvisualizer.presentation.util.SortingAlgorithm
import com.oscarlizama.domain.algorithms.bubblesort.BubbleSort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlgorithmVisualizerScreenViewModel @Inject constructor(
    private val insertionSort: InsertionSort,
    private val bubbleSort: BubbleSort
) : ViewModel() {

    var uiState by mutableStateOf(UIState())
        private set

    private fun onStart() {
        uiState = uiState.copy(
            arr = mutableStateListOf(100, 120, 80, 55, 40, 5, 25, 320, 80, 23, 534, 64)
        )
    }

    private fun onSortArray(sortingAlgorithm: SortingAlgorithm) {
        viewModelScope.launch {
            when (sortingAlgorithm) {
                SortingAlgorithm.INSERTION_SORT -> {
                    insertionSort.sort(
                        arr = uiState.arr.toIntArray().clone()
                    ) { modifiedArray ->
                        uiState.sortedArrayLevels.add(modifiedArray.toList())
                    }
                }
                SortingAlgorithm.BUBBLE_SORT -> {
                    bubbleSort.sort(
                        arr = uiState.arr.toIntArray().clone()
                    ) { modifiedArray ->
                        uiState.sortedArrayLevels.add(modifiedArray.toList())
                    }
                }
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
        if (uiState.nextStep < uiState.sortedArrayLevels.size) {
            uiState = uiState.copy(
                arr = uiState.sortedArrayLevels[uiState.nextStep].toMutableStateList(),
                nextStep = uiState.nextStep + 1,
                previousStep = uiState.previousStep + 1
            )
        }
    }

    private fun algorithmPreviousStep() {
        if (uiState.previousStep >= 0) {
            uiState = uiState.copy(
                arr = uiState.sortedArrayLevels[uiState.previousStep].toMutableStateList(),
                nextStep = uiState.nextStep - 1,
                previousStep = uiState.previousStep - 1
            )
        }
    }

    private fun speedUpAlgorithm() {
        uiState = uiState.copy(
            delay = uiState.delay - 50
        )
    }

    private fun slowDownAlgorithm() {
        if (uiState.delay >= DELAY_LIMIT) {
            uiState = uiState.copy(
                delay = uiState.delay + 50
            )
        }
    }

    private fun playPauseAlgorithm() {
        if (uiState.isPlaying)
            pauseAlgorithm()
        else
            playAlgorithm()
        uiState = uiState.copy(isPlaying = uiState.isPlaying.not())
    }

    private fun playAlgorithm() = viewModelScope.launch {
        uiState = uiState.copy(
            pause = false,
            onSortingFinished = false
        )
        for (i in uiState.sortingState until uiState.sortedArrayLevels.size) {
            if (!uiState.pause) {
                delay(uiState.delay)
                uiState = uiState.copy(
                    arr = uiState.sortedArrayLevels[i].toMutableStateList(),
                    sortingState = i
                )
            } else {
                uiState = uiState.copy(
                    sortingState = i,
                    nextStep = i + 1,
                    previousStep = i
                )
                return@launch
            }
        }
        uiState = uiState.copy(
            onSortingFinished = true,
            sortingState = 0,
            isPlaying = false
        )
    }

    private fun pauseAlgorithm() {
        uiState = uiState.copy(pause = true)
    }

    fun onUiEvent(uiEvent: UIEvent) {
        when (uiEvent) {
            is OnStart -> onStart()
            is UIEvent.OnAlgorithmEvent -> onAlgorithmEvent(algorithmEvent = uiEvent.algorithmEvent)
            is UIEvent.OnSortArray -> onSortArray(uiEvent.sortingAlgorithm)
        }
    }

    sealed class UIEvent {
        object OnStart : UIEvent()
        data class OnAlgorithmEvent(val algorithmEvent: AlgorithmEvents) : UIEvent()
        data class OnSortArray(val sortingAlgorithm: SortingAlgorithm) : UIEvent()
    }

    data class UIState(
        val arr: SnapshotStateList<Int> = mutableStateListOf(),
        val isPlaying: Boolean = false,
        val pause: Boolean = false,
        val previousStep: Int = 0,
        val nextStep: Int = 1,
        val sortingState: Int = 0,
        val onSortingFinished: Boolean = false,
        val delay: Long = 150L,
        val sortedArrayLevels: MutableList<List<Int>> = mutableListOf()
    )

    companion object {
        const val DELAY_LIMIT = 150L
    }
}