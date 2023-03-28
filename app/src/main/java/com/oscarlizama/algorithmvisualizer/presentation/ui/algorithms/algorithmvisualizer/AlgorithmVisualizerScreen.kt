package com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.algorithmvisualizer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnAlgorithmEvent
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnStart
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnSortArray
import com.oscarlizama.algorithmvisualizer.presentation.uielement.AlgorithmVisualizer
import com.oscarlizama.algorithmvisualizer.presentation.uielement.BottomBarControls
import com.oscarlizama.algorithmvisualizer.presentation.util.AlgorithmEvents
import com.oscarlizama.algorithmvisualizer.presentation.util.SortingAlgorithm
import com.oscarlizama.algorithmvisualizer.ui.util.Spacer16
import com.oscarlizama.algorithmvisualizer.ui.util.Spacer4

@Composable
fun AlgorithmVisualizerScreen() {
    val viewModel = viewModel<AlgorithmVisualizerScreenViewModel>()
    LaunchedEffect(key1 = true) {
        viewModel.onUiEvent(OnStart)
        viewModel.onUiEvent(OnSortArray(SortingAlgorithm.BUBBLE_SORT))
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
        ) {
            Spacer16()
            Text(text = "Insertion Sort Algorithm")
            Spacer4()
            Text(text = "Step: ${viewModel.uiState.sortingState}")
            Spacer16()
            if (viewModel.uiState.arr.isNotEmpty()) {
                AlgorithmVisualizer(
                    modifier = Modifier.fillMaxWidth(),
                    arr = viewModel.uiState.arr.toIntArray()
                )
            }
        }
        BottomBarControls(
            isPlaying = if (viewModel.uiState.onSortingFinished) !viewModel.uiState.onSortingFinished else viewModel.uiState.isPlaying,
            onPlayPause = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.PlayPause)) },
            onSlowDown = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.SlowDown)) },
            onSpeedUp = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.SpeedUp)) },
            onNextStep = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.Next)) },
            onPreviousStep = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.Previous)) }
        )
    }
}