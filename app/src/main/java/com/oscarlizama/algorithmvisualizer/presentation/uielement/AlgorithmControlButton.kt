package com.oscarlizama.algorithmvisualizer.presentation.uielement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AlgorithmControlButton(
    buttonIcon: ImageVector,
    onClick: () -> Unit = { }
) {
    Box {
        IconButton(
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp),
            onClick = { onClick() }
        ) {
            Icon(
                imageVector = buttonIcon,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}