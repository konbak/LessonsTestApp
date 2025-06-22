package app.example.domain.di

import app.example.domain.repository.CourseRepository
import app.example.domain.usecase.GetCoursesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCoursesUseCase(
        repository: CourseRepository
    ): GetCoursesUseCase {
        return GetCoursesUseCase(repository)
    }
}