package com.tishukoff.composetesting.ui.recomposition_fun

import android.util.Log
import androidx.compose.runtime.IntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class RecompositionViewModel : ViewModel() {

    init {
        Log.d("Logger2", "RecompositionViewModel init")
    }

    private val _state = mutableIntStateOf(0)
    val state: IntState = _state

    fun updateCounter(counter: Int) {
        _state.intValue = counter
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Logger2", "RecompositionViewModel onCleared")
    }
}