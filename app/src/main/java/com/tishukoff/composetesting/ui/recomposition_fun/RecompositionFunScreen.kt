package com.tishukoff.composetesting.ui.recomposition_fun

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.IntState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecompositionFunScreen(
    state: IntState,
    onAction: (Int) -> Unit,
) {

    val stateValue = state.intValue
    val text = remember { "Recomposition" }

    Log.d("Logger", "1. RecompositionFunScreen UPDATE")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextWithValString(text)

        Spacer(modifier = Modifier.height(16.dp))

        TextWithVarParameter(StateWithVarParameter(text))

        Spacer(modifier = Modifier.height(16.dp))

        TextWithList(ImmutableList(listOf(text)))

        Spacer(modifier = Modifier.height(16.dp))

        TextWithImmutableList(ImmutableList(listOf(text)))

        Spacer(modifier = Modifier.height(16.dp))

        TextWithSealedClass(SealedClassTest.TextWithString(text))

        Spacer(modifier = Modifier.height(16.dp))

        TextWithEmptyClass(StateWithEmptyClass(text))

        Spacer(modifier = Modifier.height(48.dp))

        Button(onClick = { onAction(stateValue + 1) }) {
            Text(text = "Counter = $stateValue", fontSize = 16.sp)
        }
    }
}

@Composable
fun TextWithValString(text: String) {
    Log.d("Logger", "TextWishString UPDATE")

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "$text with String", fontSize = 20.sp)
        }
    }
}

@Composable
fun TextWithVarParameter(state: StateWithVarParameter) {
    Log.d("Logger", "TextWithVarParameter UPDATE")

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "${state.text} with var Parameter", fontSize = 20.sp)
        }
    }
}

@Composable
fun TextWithList(textList: ImmutableList<String>) {
    Log.d("Logger", "TextWithList UPDATE")

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "${textList.first()} with List", fontSize = 20.sp)
        }
    }
}

@Composable
fun TextWithImmutableList(textList: ImmutableList<String>) {
    Log.d("Logger", "TextWithImmutableList UPDATE")

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "${textList.first()} with Immutable List", fontSize = 20.sp)
        }
    }
}

@Composable
fun TextWithSealedClass(sealedClass: SealedClassTest) {
    Log.d("Logger", "TextWithSealedClass UPDATE")

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "${sealedClass.text} with Sealed Class", fontSize = 20.sp)
        }
    }
}

@Composable
fun TextWithEmptyClass(emptyClass: StateWithEmptyClass) {
    Log.d("Logger", "StateWithEmptyClass UPDATE")

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "${emptyClass.text} with Empty Class", fontSize = 20.sp)
        }
    }
}

data class StateWithVarParameter(val text: String)

data class StateWithEmptyClass(val text: String)

@JvmInline
@Immutable
value class ImmutableList<T>(val data: List<T>) : List<T> by data


sealed class SealedClassTest(val text: String) {
    data class TextWithString(private val _text: String) : SealedClassTest(_text)
}

sealed interface SealedInterfaceTest {
    data class TextWithString(val text: String): SealedInterfaceTest
}