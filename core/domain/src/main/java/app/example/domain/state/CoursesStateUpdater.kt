package app.example.domain.state

interface CoursesStateUpdater {
    fun updateCourseProgressInState(courseId: Int, progress: Int)
}