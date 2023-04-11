package com.oscarlizama.algorithmvisualizer.presentation.util

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class SortingAlgorithm(val displayName: String) : Parcelable {
    BUBBLE_SORT("Bubble sort"),
    INSERTION_SORT("Insertion sort")
}