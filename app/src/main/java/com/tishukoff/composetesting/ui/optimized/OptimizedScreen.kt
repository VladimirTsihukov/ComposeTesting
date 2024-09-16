package com.tishukoff.composetesting.ui.optimized

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.IntState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptimizedScreen(
    state: State<OptimizedState>,
    onAction: (Int) -> Unit,
) {

    Log.d("Logger", "2. OptimizedScreen UPDATE")

    OptimizedView(state, onAction)
}

@Composable
fun OptimizedView(state: State<OptimizedState>, onAction: (Int) -> Unit) {

    Log.d("Logger", "3. OptimizedView UPDATE")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        InfoView(state, onAction)
    }
}

@Composable
fun InfoView(state: State<OptimizedState>, onAction: (Int) -> Unit) {
    val stateValue = state.value

    Log.d("Logger", "4. TextView UPDATE")

    Text(text = stateValue.title, fontSize = 32.sp)

    Spacer(modifier = Modifier.height(16.dp))

    Text(text = stateValue.subTitle, fontSize = 32.sp)

    Spacer(modifier = Modifier.height(16.dp))

    CounterView(stateValue.counter, onAction)
}

@Composable
fun CounterView(counterState: State<Int>, onAction: (Int) -> Unit) {
    val counterValue = counterState.value
    Log.d("Logger", "5. CounterView UPDATE")

    Text(text = "Counter = $counterValue", fontSize = 32.sp)

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = { onAction.invoke(counterValue + 1) }) {
        Text(text = "Button")
    }
}