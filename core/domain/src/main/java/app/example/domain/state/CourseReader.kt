package app.example.domain.state

import app.example.domain.model.Course
import kotlinx.coroutines.flow.StateFlow

interface CoursesReader {
    val courses: StateFlow<List<Course>>
}