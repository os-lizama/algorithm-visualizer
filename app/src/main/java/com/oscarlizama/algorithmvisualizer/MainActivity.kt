package com.oscarlizama.algorithmvisualizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph.Navigation
import com.oscarlizama.algorithmvisualizer.ui.theme.AlgorithmVisualizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgorithmVisualizerTheme {
                Navigation()
            }
        }
    }
}