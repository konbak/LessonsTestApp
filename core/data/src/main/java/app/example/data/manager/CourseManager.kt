package app.example.data.manager

import app.example.domain.model.Course
import app.example.domain.state.CoursesReader
import app.example.domain.state.CoursesStateUpdater
import app.example.domain.state.CoursesSetter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoursesManager @Inject constructor() : CoursesSetter, CoursesReader, CoursesStateUpdater {
    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    override val courses = _courses.asStateFlow()

    override fun setCourses(courses: List<Course>) {
        _courses.value = courses
    }

    override fun updateCourseProgressInState(courseId: Int, progress: Int) {
        _courses.value = _courses.value.map {
            if (it.id == courseId) it.copy(progress = progress) else it
        }
    }
}