package app.example.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.example.designsystem.components.CourseCard
import app.example.domain.model.Course

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onCourseSelected: (Int) -> Unit,
) {
    val courses by viewModel.courses.collectAsState()

    HomeContent(
        courses = courses,
        onCourseSelected = onCourseSelected,
    )
}

@Composable
internal fun HomeContent(
    courses: List<Course>,
    onCourseSelected: (Int) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(courses) { course ->
            CourseCard(
                imageUrl = course.imageUrl,
                title = course.title,
                description = course.description,
                progress = course.progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onCourseSelected(course.id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    val sampleCourses = listOf(
        Course(
            id = 1,
            imageUrl = "https://via.placeholder.com/300",
            title = "Kotlin for Beginners",
            description = "Learn the basics of Kotlin programming language.",
            progress = 30,
        ),
        Course(
            id = 2,
            imageUrl = "https://via.placeholder.com/300",
            title = "Advanced Android",
            description = "Dive deep into advanced Android topics.",
            progress = 70,
        ),
        Course(
            id = 3,
            imageUrl = "https://via.placeholder.com/300",
            title = "Jetpack Compose",
            description = "Build beautiful UIs with Jetpack Compose.",
            progress = 50,
        )
    )

    HomeContent(
        courses = sampleCourses,
        onCourseSelected = { }
    )
}