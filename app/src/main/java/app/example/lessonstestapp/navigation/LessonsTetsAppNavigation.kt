package app.example.lessonstestapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.example.details.DetailsScreen
import app.example.details.DetailsViewModel
import app.example.home.HomeScreen
import app.example.home.HomeViewModel

@Composable
fun LessonsTestAppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LessonsTestAppScreens.Home.name
    ) {
        composable(route = LessonsTestAppScreens.Home.name) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                viewModel = homeViewModel,
                onCourseSelected = { courseId ->
                    navController.navigate(LessonsTestAppScreens.Details.name+"/"+courseId)
                },
            )
        }

        composable(
            route = "${LessonsTestAppScreens.Details.name}/{courseId}",
            arguments = listOf(navArgument("courseId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getInt("courseId") ?: 0
            val detailsViewModel = hiltViewModel<DetailsViewModel>()
            DetailsScreen(
                courseId = courseId,
                viewModel = detailsViewModel,
            )
        }
    }
}