package app.example.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.example.designsystem.components.EditableProgressBar
import app.example.domain.model.Course

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val course by viewModel.selectedCourse.collectAsState()

    course?.let { selectedCourse ->
        DetailsContent(
            course = selectedCourse,
            onProgressChanged = { newProgress ->
                viewModel.updateCourseProgress(newProgress)
            },
        )
    }
}

@Composable
internal fun DetailsContent(
    course: Course,
    onProgressChanged: (Int) -> Unit,
) {
    var progress by remember { mutableIntStateOf(course.progress) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = course.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = course.description,
            style = MaterialTheme.typography.bodyLarge,
        )

        EditableProgressBar(
            progress = progress,
            onProgressChanged = { newProgress ->
                progress = newProgress
                onProgressChanged(newProgress)
            }
        )
    }
}