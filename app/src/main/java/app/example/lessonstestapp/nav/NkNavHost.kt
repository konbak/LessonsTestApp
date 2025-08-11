package app.example.lessonstestapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

private const val MAIN_GRAPH_ROUTE = "main_graph"

@Composable
fun NkNavHost(appState: AppState) {
    NavHost(
        navController = appState.navController,
        startDestination = MAIN_GRAPH_ROUTE,
    ) {
        mainGraph(
            navController = appState.navController,
            startDestination = appState.startDestination,
        )
    }
}
