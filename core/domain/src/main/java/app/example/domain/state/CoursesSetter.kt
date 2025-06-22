package app.example.domain.state

import app.example.domain.model.Course

interface CoursesSetter {
    fun setCourses(courses: List<Course>)
}