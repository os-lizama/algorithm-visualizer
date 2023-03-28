package com.oscarlizama.algorithmvisualizer.presentation.uielement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.PauseCircleOutline
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BottomBarControls(
    modifier: Modifier = Modifier,
    isPlaying: Boolean = false,
    onPlayPause: () -> Unit,
    onSlowDown: () -> Unit,
    onSpeedUp: () -> Unit,
    onNextStep: () -> Unit,
    onPreviousStep: () -> Unit
) {
    BottomAppBar(
        modifier = modifier
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Previous button
            AlgorithmControlButton(
                buttonIcon = Icons.Default.NavigateBefore
            ) { onPreviousStep() }

            // Play/Pause button
            AlgorithmControlButton(
                buttonIcon = if (!isPlaying) Icons.Default.PlayCircleOutline else Icons.Default.PauseCircleOutline
            ) { onPlayPause() }

            // Next previous
            AlgorithmControlButton(
                buttonIcon = Icons.Default.NavigateNext
            ) { onNextStep() }

            // Slow down button
            AlgorithmControlButton(
                buttonIcon = Icons.Default.Remove
            ) { onSlowDown() }

            // Speed up button
            AlgorithmControlButton(
                buttonIcon = Icons.Default.Add
            ) { onSpeedUp() }
        }
    }
}