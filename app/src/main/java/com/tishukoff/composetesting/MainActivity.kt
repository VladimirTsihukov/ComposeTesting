package com.tishukoff.composetesting

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tishukoff.composetesting.ui.failed_ui.FailedUiScreen
import com.tishukoff.composetesting.ui.failed_ui.FailedUiViewModel
import com.tishukoff.composetesting.ui.immutable_test.ImmutableTestScreen
import com.tishukoff.composetesting.ui.immutable_test.ImmutableTestViewModel
import com.tishukoff.composetesting.ui.main.MainScreen
import com.tishukoff.composetesting.ui.not_optimized.NotOptimizedScreen
import com.tishukoff.composetesting.ui.not_optimized.NotOptimizedViewModel
import com.tishukoff.composetesting.ui.optimized.OptimizedScreen
import com.tishukoff.composetesting.ui.optimized.OptimizedViewModel
import com.tishukoff.composetesting.ui.recomposition_fun.RecompositionFunScreen
import com.tishukoff.composetesting.ui.recomposition_fun.RecompositionViewModel
import com.tishukoff.composetesting.ui.test.MySingleton
import com.tishukoff.composetesting.ui.test.TestingStateScreen
import com.tishukoff.composetesting.ui.theme.ComposeTestingTheme

const val TAG_LOG = "TAG_LOG"

const val ARGUMENT_ID = "id"
const val ARGUMENT_KEY = "/{$ARGUMENT_ID}"
const val START_MAIN_SCREEN_DESTINATION = "start_main_destination"
const val START_OPTIMIZED_SCREEN_DESTINATION = "start_optimized_screen_destination"
const val START_NOT_OPTIMIZED_SCREEN_DESTINATION = "start_not_optimized_screen_destination"
const val START_RECOMPOSITION_FUN_DESTINATION = "start_recomposition_fun_destination"
const val START_IMMUTABLE_TEST_DESTINATION = "start_immutable_test_destination"
const val START_IMMUTABLE_TEST_FAILED_UI = "start_immutable_test_failed_ui"
const val START_CHECK_STATE_TEST = "start_check_state_test"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG_LOG, "Before init singleton")
        MySingleton.doSomething()
        enableEdgeToEdge()
        setContent {
            ComposeTestingTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = START_MAIN_SCREEN_DESTINATION) {

        composable(START_MAIN_SCREEN_DESTINATION) {
            MainScreen(navController)
        }

        composable(
            route = START_OPTIMIZED_SCREEN_DESTINATION + ARGUMENT_KEY,
            arguments = listOf(navArgument(ARGUMENT_ID) { type = NavType.StringType })
        ) {
            val argument = it.arguments?.getString(ARGUMENT_ID)
            val viewModel: OptimizedViewModel = viewModel()
            Log.d("Logger", "1. Navigate to OptimizedScreen")

            OptimizedScreen(viewModel.state) { viewModel.updateCounter(it) }
        }

        composable(START_NOT_OPTIMIZED_SCREEN_DESTINATION) {
            val viewModel: NotOptimizedViewModel = viewModel()
            val stateValue = viewModel.state.value
            Log.d("Logger", "1. Navigate to NotOptimizedScreen")

            NotOptimizedScreen(stateValue) { viewModel.updateCounter(it) }
        }

        composable(START_RECOMPOSITION_FUN_DESTINATION) {
            val viewModel: RecompositionViewModel = viewModel()
            RecompositionFunScreen(viewModel.state) { viewModel.updateCounter(it) }
        }

        composable(START_IMMUTABLE_TEST_DESTINATION) {
            val viewModel: ImmutableTestViewModel = viewModel()
            ImmutableTestScreen(viewModel.state, viewModel.counter) { viewModel.updateCounter(it) }
        }

        composable(START_IMMUTABLE_TEST_FAILED_UI) {
            val viewModel: FailedUiViewModel = viewModel()
            FailedUiScreen(
                viewModel.state,
                viewModel.counter,
            ) { viewModel.updateCounter(it) }
        }

        composable(START_CHECK_STATE_TEST) {
            TestingStateScreen()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestingTheme {
        MyApp()
    }
}