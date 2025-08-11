package app.example.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.example.home.HomeScreen
import app.example.home.HomeViewModel

const val homeScreenRoute = "home"

fun NavGraphBuilder.homeScreen(
    navigateToDetails: (Int) -> Unit,
) {
    composable(route = homeScreenRoute) {
        val vm: HomeViewModel = hiltViewModel()
        HomeScreen(
            viewModel = vm,
            onCourseSelected = navigateToDetails,
        )
    }
}

fun NavController.navigateToHome(popUpToRoot: Boolean = false) {
    navigate(homeScreenRoute) {
        if (popUpToRoot) {
            popUpTo(graph.startDestinationId) { inclusive = true }
        }
        launchSingleTop = true
    }
}
