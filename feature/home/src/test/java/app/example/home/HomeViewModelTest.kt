package app.example.home

import app.example.domain.model.Course
import app.example.domain.state.CoursesReader
import app.example.domain.state.CoursesSetter
import app.example.domain.usecase.GetCoursesUseCase
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var getCoursesUseCase: GetCoursesUseCase
    private lateinit var coursesSetter: CoursesSetter
    private lateinit var coursesReader: CoursesReader

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        getCoursesUseCase = mockk()
        coursesSetter = mockk()

        val coursesFlow = MutableStateFlow<List<Course>>(emptyList())
        coursesReader = mockk {
            every { courses } returns coursesFlow
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `init calls getCoursesUseCase and sets courses`() = runTest {
        val fakeCourses = listOf(
            Course(1, "Title 1", "Desc 1", "url1", 10),
            Course(2, "Title 2", "Desc 2", "url2", 20)
        )

        coEvery { getCoursesUseCase.invoke() } returns fakeCourses
        every { coursesSetter.setCourses(fakeCourses) } just Runs

        homeViewModel = HomeViewModel(
            getCoursesUseCase,
            coursesSetter,
            coursesReader,
        )

        testDispatcher.scheduler.advanceUntilIdle()

        coVerify(exactly = 1) { getCoursesUseCase.invoke() }
        verify(exactly = 1) { coursesSetter.setCourses(fakeCourses) }

        assertEquals(emptyList(), homeViewModel.courses.value)
    }
}