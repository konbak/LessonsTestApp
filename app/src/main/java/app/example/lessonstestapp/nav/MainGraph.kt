package app.example.lessonstestapp.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import app.example.details.navigation.detailsScreen
import app.example.details.navigation.navigateToDetails
import app.example.home.navigation.homeScreen

private const val MAIN_GRAPH_ROUTE = "main_graph"

fun NavGraphBuilder.mainGraph(
    navController: NavHostController,
    startDestination: String,
) {
    navigation(
        route = MAIN_GRAPH_ROUTE,
        startDestination = startDestination, // homeScreenRoute
    ) {
        homeScreen(
            navigateToDetails = { courseId ->
                navController.navigateToDetails(courseId)
            }
        )
        detailsScreen()
    }
}
