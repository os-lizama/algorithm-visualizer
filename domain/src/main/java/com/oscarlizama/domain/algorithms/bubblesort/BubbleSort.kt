package com.oscarlizama.domain.algorithms.bubblesort

class BubbleSort {

    fun sort(
        arr: IntArray,
        onSwap: (IntArray) -> Unit
    ) {
        for (pass in 0 until (arr.size - 1)) {
            for (currentPosition in 0 until (arr.size - pass - 1)) {
                if (arr[currentPosition] > arr[currentPosition + 1]) {
                    val tmp = arr[currentPosition]
                    arr[currentPosition] = arr[currentPosition + 1]
                    arr[currentPosition + 1] = tmp
                }
                onSwap(arr)
            }
        }
    }

}