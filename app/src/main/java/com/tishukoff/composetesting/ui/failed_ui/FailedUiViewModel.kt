package com.tishukoff.composetesting.ui.failed_ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FailedUiViewModel : ViewModel() {

    init {
        Log.d("Logger2", "FailedUiViewModel init")
    }

    private val _state = mutableIntStateOf(0)
    val state: State<Int> = _state

    private val _counter = mutableStateOf(ImmutableCounter2(0))
    val counter: State<ImmutableCounter2> = _counter

    fun updateCounter(counter: Int) {
        _state.intValue = counter
        _counter.value = _counter.value.copy(count = counter)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Logger2", "FailedUiViewModel onCleared")
    }
}

data class ImmutableCounter2(
    var count: Int = 0,
)