package app.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.example.domain.state.CoursesReader
import app.example.domain.state.CoursesSetter
import app.example.domain.usecase.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val coursesStateSetter: CoursesSetter,
    coursesReader: CoursesReader,
) : ViewModel() {

    val courses = coursesReader.courses

    init {
        viewModelScope.launch {
            val fetchedCourses = getCoursesUseCase()
            coursesStateSetter.setCourses(fetchedCourses)
        }
    }
}