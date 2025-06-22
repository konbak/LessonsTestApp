package app.example.data.repository

import app.example.data.dto.CourseDto
import app.example.data.mapper.toCourse
import app.example.domain.model.Course
import app.example.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor() : CourseRepository {

    private val courses = mutableListOf(
        CourseDto(
            id = 1,
            title = "Compose Basics",
            description = "Learn Jetpack Compose",
            imageUrl = "https://assets.schoox.com/images/product/ef-light/learning-course-about-page.png",
            progress = 20,
        ),
        CourseDto(
            id = 2,
            title = "Clean Architecture",
            description = "Learn to implement Clean architecture in Android using SOLID principles and MVVM with long description",
            imageUrl = "https://assets.schoox.com/images/product/ef-light/learning-course-about-page.png",
            progress = 50,
        ),
        CourseDto(
            id = 3,
            title = "Hilt Injection",
            description = "Learn Dependency Injection",
            imageUrl = "https://assets.schoox.com/images/product/ef-light/learning-course-about-page.png",
            progress = 80,
        )
    )

    override suspend fun getCourses(): List<Course> = courses.map { it.toCourse() }
}
