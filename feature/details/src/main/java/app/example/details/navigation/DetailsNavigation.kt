package app.example.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.example.details.DetailsScreen

const val detailsBaseRoute = "details"
private const val argCourseId = "courseId"
private const val detailsRoutePattern = "$detailsBaseRoute/{$argCourseId}"

fun NavGraphBuilder.detailsScreen() {
    composable(
        route = detailsRoutePattern,
        arguments = listOf(navArgument(argCourseId) { type = NavType.IntType })
    ) {
        DetailsScreen()
    }
}

fun NavController.navigateToDetails(courseId: Int) {
    navigate("$detailsBaseRoute/$courseId")
}
