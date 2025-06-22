package app.example.domain.usecase

import app.example.domain.model.Course
import app.example.domain.repository.CourseRepository

class GetCoursesUseCase(
    private val repository: CourseRepository
) {
    suspend operator fun invoke(): List<Course> {
        return repository.getCourses()
    }
}