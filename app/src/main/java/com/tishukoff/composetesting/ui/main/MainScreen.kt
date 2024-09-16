package com.tishukoff.composetesting.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tishukoff.composetesting.START_CHECK_STATE_TEST
import com.tishukoff.composetesting.START_IMMUTABLE_TEST_DESTINATION
import com.tishukoff.composetesting.START_IMMUTABLE_TEST_FAILED_UI
import com.tishukoff.composetesting.START_NOT_OPTIMIZED_SCREEN_DESTINATION
import com.tishukoff.composetesting.START_OPTIMIZED_SCREEN_DESTINATION
import com.tishukoff.composetesting.START_RECOMPOSITION_FUN_DESTINATION

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { navController.navigate("$START_OPTIMIZED_SCREEN_DESTINATION/325") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Check STATE Optimized", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(START_NOT_OPTIMIZED_SCREEN_DESTINATION) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Check STATE NOT Optimized", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { navController.navigate(START_RECOMPOSITION_FUN_DESTINATION) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Check recomposition funs", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { navController.navigate(START_IMMUTABLE_TEST_DESTINATION) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Check immutable annotation", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(START_IMMUTABLE_TEST_FAILED_UI) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Check immutable test failed ui", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { navController.navigate(START_CHECK_STATE_TEST) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Check state", fontSize = 16.sp)
        }
    }
}