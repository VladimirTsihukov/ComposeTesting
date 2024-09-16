package com.tishukoff.composetesting.ui.animation_test

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun AnimationTestScreen(show: Boolean) {
    val myAlpha = animateFloatAsState(targetValue = if (show) 1f else 0f)
    Item(modifier = Modifier.graphicsLayer {
        alpha = myAlpha.value
    })
}

@Composable
fun Item(modifier: Modifier) {

}

@Composable
fun AnimateProgress(progress: State<Int>) {
    val smoothProgress = remember {
        Animatable(
            initialValue = 0,
            typeConverter = Int.VectorConverter
        )
    }

    LaunchedEffect(Unit) {
        snapshotFlow { progress.value }
            .collect { newValue ->
                smoothProgress.animateTo(newValue, tween(1000, easing = LinearEasing))
            }
    }

}