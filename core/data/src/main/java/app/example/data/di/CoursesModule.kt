package app.example.data.di

import app.example.data.manager.CoursesManager
import app.example.domain.state.CoursesReader
import app.example.domain.state.CoursesSetter
import app.example.domain.state.CoursesStateUpdater
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoursesModule {

    @Provides
    @Singleton
    fun provideCoursesManager(): CoursesManager = CoursesManager()

    @Provides
    fun provideCoursesReader(manager: CoursesManager): CoursesReader = manager

    @Provides
    fun provideCoursesSetter(manager: CoursesManager): CoursesSetter = manager

    @Provides
    fun provideCoursesStateUpdater(manager: CoursesManager): CoursesStateUpdater = manager
}