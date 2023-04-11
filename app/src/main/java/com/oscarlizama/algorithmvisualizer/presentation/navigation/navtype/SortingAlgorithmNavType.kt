package com.oscarlizama.algorithmvisualizer.presentation.navigation.navtype

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.oscarlizama.algorithmvisualizer.presentation.util.SortingAlgorithm

class SortingAlgorithmNavType : NavType<SortingAlgorithm>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): SortingAlgorithm? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): SortingAlgorithm {
        return Gson().fromJson(value, SortingAlgorithm::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: SortingAlgorithm) {
        bundle.putParcelable(key, value)
    }

}