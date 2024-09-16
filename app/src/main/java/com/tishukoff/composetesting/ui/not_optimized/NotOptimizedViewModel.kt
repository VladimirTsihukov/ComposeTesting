package com.tishukoff.composetesting.ui.not_optimized

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NotOptimizedViewModel : ViewModel() {

    init {
        Log.d("Logger2", "NotOptimizedViewModel init")
    }

    private val _state = mutableStateOf(NotOptimizedState())
    val state: State<NotOptimizedState> = _state

    fun updateCounter(counter: Int) {
        _state.value = _state.value.copy(counter = counter)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Logger2", "NotOptimizedViewModel onCleared")
    }
}

data class NotOptimizedState(
    val title: String = "Title",
    val subTitle: String = "Subtitle",
    val counter: Int = 0,
)