package app.example.data.mapper

import app.example.data.dto.CourseDto
import app.example.domain.model.Course

fun CourseDto.toCourse(): Course {
    return Course(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        progress = progress,
    )
}