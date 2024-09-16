package com.tishukoff.composetesting.ui.optimized

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OptimizedViewModel : ViewModel() {

    init {
        Log.d("Logger2", "OptimizedViewModel init")
    }

    private val _state = mutableStateOf(OptimizedState())
    val state: State<OptimizedState> = _state

    fun updateCounter(counter: Int) {
        _state.value.counter.value = counter
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Logger2", "OptimizedViewModel onCleared")
    }
}

data class OptimizedState(
    val title: String = "Title",
    val subTitle: String = "SubTitle",
    val counter: MutableState<Int> = mutableIntStateOf(0),
)
