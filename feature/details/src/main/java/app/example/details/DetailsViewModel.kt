package app.example.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.example.domain.model.Course
import app.example.domain.state.CoursesReader
import app.example.domain.state.CoursesStateUpdater
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val coursesReader: CoursesReader,
    private val coursesStateUpdater: CoursesStateUpdater,
): ViewModel() {

    private val _selectedCourse = MutableStateFlow<Course?>(null)
    val selectedCourse: StateFlow<Course?> = _selectedCourse

    fun loadCourse(courseId: Int) {
        viewModelScope.launch {
            coursesReader.courses.collect { courses ->
                _selectedCourse.value = courses.find { it.id == courseId }
            }
        }
    }

    fun updateCourseProgress(newProgress: Int) {
        val courseId = _selectedCourse.value?.id ?: return
        coursesStateUpdater.updateCourseProgressInState(courseId, newProgress)

        _selectedCourse.value = _selectedCourse.value?.copy(progress = newProgress)
    }
}