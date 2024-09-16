package com.tishukoff.composetesting.ui.immutable_test

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.IntState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEach

@Composable
fun ImmutableTestScreen(
    state: State<ImmutableTestState>,
    counterState: IntState,
    onAction: (Int) -> Unit,
) {

    val stateValue = state.value
    val counterValue = counterState.intValue

    Log.d("Logger", "ImmutableTestScreen UPDATE $stateValue")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Title", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(32.dp))

        ImmutableTestView(stateValue)

        Button(onClick = { onAction(counterValue + 1) }) {
            Text(text = "Increment counter", fontSize = 16.sp)
        }
    }
}

@Composable
fun ImmutableTestView(stateValue: ImmutableTestState) {
    Log.d("Logger", "ImmutableTestView UPDATE")

    Text(text = stateValue.subTitle, fontSize = 24.sp)

    Spacer(modifier = Modifier.height(16.dp))

    stateValue.list.fastForEach { item ->
        Log.d("Logger", "item = $item")
        Text(text = "Count = $item", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))
    }

    Spacer(modifier = Modifier.height(32.dp))
}