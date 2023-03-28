package com.oscarlizama.algorithmvisualizer.ui.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.Spacer(length: Dp) {
    Spacer(modifier = Modifier.height(length))
}

@Composable
fun RowScope.Spacer(length: Dp) {
    Spacer(modifier = Modifier.height(length))
}

@Composable
fun ColumnScope.Spacer4() = Spacer(4.dp)

@Composable
fun ColumnScope.Spacer8() = Spacer(8.dp)

@Composable
fun ColumnScope.Spacer16() = Spacer(16.dp)

@Composable
fun RowScope.Spacer4() = Spacer(4.dp)

@Composable
fun RowScope.Spacer8() = Spacer(8.dp)

@Composable
fun RowScope.Spacer16() = Spacer(16.dp)