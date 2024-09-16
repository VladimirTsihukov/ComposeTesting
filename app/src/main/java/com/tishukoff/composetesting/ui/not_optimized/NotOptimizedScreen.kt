package com.tishukoff.composetesting.ui.not_optimized

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotOptimizedScreen(state: NotOptimizedState, onAction: (Int) -> Unit) {

    Log.d("Logger", "2. NOT_OptimizedScreen UPDATE")

    NotOptimizedView(state, onAction)
}

@Composable
fun NotOptimizedView(state: NotOptimizedState, onAction: (Int) -> Unit) {

    Log.d("Logger", "3. NOT_OptimizedView UPDATE")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InfoView2(state, onAction)
    }
}

@Composable
fun InfoView2(stateValue: NotOptimizedState, onAction: (Int) -> Unit) {

    Log.d("Logger", "4. InfoView2 UPDATE")

    Text(text = stateValue.title, fontSize = 32.sp)

    Spacer(modifier = Modifier.height(16.dp))

    Text(text = stateValue.subTitle, fontSize = 32.sp)

    Spacer(modifier = Modifier.height(16.dp))

    CounterView2(stateValue.counter, onAction)
}

@Composable
fun CounterView2(counter: Int, onAction: (Int) -> Unit) {
    Log.d("Logger", "5. CounterView2 UPDATE")

    Text(text = "Counter = $counter", fontSize = 32.sp)

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = { onAction.invoke(counter + 1) }) {
        Text(text = "Button")
    }
}