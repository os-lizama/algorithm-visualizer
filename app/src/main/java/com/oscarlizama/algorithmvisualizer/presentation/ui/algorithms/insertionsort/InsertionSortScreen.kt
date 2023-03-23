package com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.insertionsort

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.insertionsort.InsertionSortScreenViewModel.UIEvent.OnAlgorithmEvent
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithms.insertionsort.InsertionSortScreenViewModel.UIEvent.OnStart
import com.oscarlizama.algorithmvisualizer.presentation.uielement.BottomBarControls
import com.oscarlizama.algorithmvisualizer.presentation.util.AlgorithmEvents
import com.oscarlizama.algorithmvisualizer.ui.util.Spacer16
import com.oscarlizama.data.algorithms.insertionsort.InsertionSort

@Composable
fun InsertionSortScreen(
    viewModel: InsertionSortScreenViewModel = InsertionSortScreenViewModel(insertionSort = InsertionSort())
) {
    LaunchedEffect(key1 = true) {
        viewModel.onUiEvent(OnStart)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            Modifier.padding(horizontal = 8.dp)
        ) {
            Spacer16()
            Text(text = "Insertion Sort Algorithm")
            Spacer16()
        }
        BottomBarControls(
            isPlaying = viewModel.uiState.isPlaying,
            onPlayPause = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.PlayPause)) },
            onSlowDown = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.SlowDown)) },
            onSpeedUp = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.SpeedUp)) },
            onNextStep = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.Next)) },
            onPreviousStep = { viewModel.onUiEvent(OnAlgorithmEvent(AlgorithmEvents.Previous)) }
        )
    }
}