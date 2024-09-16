package com.tishukoff.composetesting.ui.failed_ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FailedUiScreen(
    state: State<Int>,
    stateCounter: State<ImmutableCounter2>,
    onAction: (Int) -> Unit,
) {

    val stateValue = state.value
    val counter = remember { ImmutableCounter2(stateValue) }
    counter.count = stateValue

    Log.d("Logger", "FailedUiScreen UPDATE")
    Log.d("Logger", "counter: $counter")
    Log.d("Logger", "counter: ${System.identityHashCode(counter)}")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Title", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(32.dp))

        FailedUiStateView(counter)

        Button(onClick = { onAction(stateValue + 1) }) {
            Text(text = "Increment counter", fontSize = 16.sp)
        }
    }
}

@Composable
fun FailedUiStateView(stateValue: ImmutableCounter2) {
    Text(text = "Count = ${stateValue.count}", fontSize = 24.sp)

    Spacer(modifier = Modifier.height(16.dp))
}
