package com.oscarlizama.algorithmvisualizer.presentation.uielement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AlgorithmVisualizer(
    modifier: Modifier = Modifier,
    arr: IntArray
) {
    BoxWithConstraints(modifier = modifier) {
        val maxHeight = constraints.maxHeight
        val maxWidth = constraints.maxWidth
        val itemWidth = remember {
            if (maxWidth < 1440)
                ((maxWidth / arr.size) / 3.5).toInt()
            else
                ((maxWidth / arr.size) / 4.5).toInt()
        }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            arr.forEach {
                Box(
                    modifier = Modifier
                        .height(if (it.dp > maxHeight.dp) maxHeight.dp else it.dp)
                        .width(itemWidth.dp)
                        .background(
                            Color.Red,
                            shape = RoundedCornerShape(
                                topStart = 5.dp,
                                topEnd = 5.dp
                            )
                        )
                )
            }
        }
    }
}