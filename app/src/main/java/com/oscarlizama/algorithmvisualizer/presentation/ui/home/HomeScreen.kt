package com.oscarlizama.algorithmvisualizer.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.oscarlizama.algorithmvisualizer.presentation.navigation.Screen
import com.oscarlizama.algorithmvisualizer.presentation.util.NavEvent
import com.oscarlizama.algorithmvisualizer.presentation.util.SortingAlgorithm
import com.oscarlizama.algorithmvisualizer.ui.util.Spacer4

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigate: (NavEvent.Navigate) -> Unit = {}
) {
    LaunchedEffect(key1 = true) {
        viewModel.apply {
            executeNavigation(
                onNavigate = onNavigate
            )
        }
    }
    Column(
        Modifier.fillMaxSize()
    ) {
        AlgorithmsList(algorithms = viewModel.algorithms.toList()) { sortingAlgorithm ->
            viewModel.onUIEvent(HomeViewModel.UIEvent.OnNavigateToAlgorithmVisualizer(sortingAlgorithm))
        }
    }

}

@Composable
fun AlgorithmsList(
    algorithms: List<SortingAlgorithm>,
    onNavigateToAlgorithmVisualizer: (SortingAlgorithm) -> Unit
) {
    LazyColumn {
        items(algorithms) { item ->
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .clickable {
                        onNavigateToAlgorithmVisualizer(item)
                    }
            ) {
                Text(text = item.displayName)
                Spacer4()
            }
        }
    }
}