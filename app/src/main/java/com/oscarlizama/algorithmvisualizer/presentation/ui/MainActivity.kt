package com.oscarlizama.algorithmvisualizer.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.oscarlizama.algorithmvisualizer.presentation.navigation.navgraph.Navigation
import com.oscarlizama.algorithmvisualizer.ui.theme.AlgorithmVisualizerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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