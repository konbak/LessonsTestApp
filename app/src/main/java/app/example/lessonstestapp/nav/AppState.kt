package app.example.lessonstestapp.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberAppState(
    startDestination: String,
    navController: NavHostController = rememberNavController(),
): AppState = remember(startDestination, navController) {
    AppState(navController, startDestination)
}

class AppState(
    val navController: NavHostController,
    val startDestination: String,
)
