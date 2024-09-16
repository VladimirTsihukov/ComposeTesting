package com.tishukoff.composetesting.ui.immutable_test

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.IntState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ImmutableTestViewModel : ViewModel() {

    init {
        Log.d("Logger2", "ImmutableTestViewModel init")
    }

    private val _state = mutableStateOf(ImmutableTestState())
    val state: State<ImmutableTestState> = _state

    private val _counter = mutableIntStateOf(0)
    val counter: IntState = _counter

    fun updateCounter(counter: Int) {
        _counter.intValue = counter
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Logger2", "ImmutableTestViewModel onCleared")
    }
}

@Immutable
data class ImmutableTestState(
    val subTitle: String = "SubTitle",
    val list: List<Int> = listOf(1, 2, 3),
)

/*data class ImmutableTestState(
    val subTitle: String = "SubTitle",
    val list: ImmutableList<Int> = ImmutableList(listOf(1, 2, 3)),
)*/
