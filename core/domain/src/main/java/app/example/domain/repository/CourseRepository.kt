package app.example.domain.repository

import app.example.domain.model.Course

interface CourseRepository {
    suspend fun getCourses(): List<Course>
}