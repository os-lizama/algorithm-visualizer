package com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer

import androidx.activity.compose.BackHandler
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnAlgorithmEvent
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnNavigateBack
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnStart
import com.oscarlizama.algorithmvisualizer.presentation.ui.algorithmvisualizer.AlgorithmVisualizerScreenViewModel.UIEvent.OnSortArray
import com.oscarlizama.algorithmvisualizer.presentation.uielement.AlgorithmVisualizer
import com.oscarlizama.algorithmvisualizer.presentation.uielement.BottomBarControls
import com.oscarlizama.algorithmvisualizer.presentation.util.AlgorithmEvents
import com.oscarlizama.algorithmvisualizer.presentation.util.NavEvent
import com.oscarlizama.algorithmvisualizer.ui.util.Spacer16
import com.oscarlizama.algorithmvisualizer.ui.util.Spacer4

@Composable
fun AlgorithmVisualizerScreen(
    onPopBackStack: (NavEvent.PopBackStack) -> Unit = {},
    viewModel: AlgorithmVisualizerScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {

        viewModel.executeNavigation(
            onPopBackStack = onPopBackStack
        )

        viewModel.onUiEvent(OnStart)
        viewModel.onUiEvent(OnSortArray(viewModel.algorithm))
    }

    BackHandler {
        viewModel.onUiEvent(OnNavigateBack)
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
        }
        Column {
            if (viewModel.uiState.arr.isNotEmpty()) {
                AlgorithmVisualizer(
                    modifier = Modifier.fillMaxWidth(),
                    arr = viewModel.uiState.arr.toIntArray()
                )
                Spacer4()
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
}