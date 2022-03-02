package softing.ubah4ukdev.lessonapp.data.repository.datasource

import softing.ubah4ukdev.lessonapp.data.mockGetExam
import softing.ubah4ukdev.lessonapp.data.mockGetHomWork
import softing.ubah4ukdev.lessonapp.data.mockGetLessons
import softing.ubah4ukdev.lessonapp.data.models.FacultativeResponse
import softing.ubah4ukdev.lessonapp.data.models.LessonResponse
import softing.ubah4ukdev.lessonapp.data.tags
import softing.ubah4ukdev.lessonapp.domain.AppState
import softing.ubah4ukdev.lessonapp.domain.models.*

/**
 *   Project: LessonApp
 *
 *   Package: softing.ubah4ukdev.lessonapp.data.repository.datasource
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2022.02.28
 *
 *   v1.0
 */
class MockDataSourceImpl : DataSource {
    override suspend fun getLessons(): AppState<Lessons> {
        val result = mockGetLessons()
        return AppState.Success<Lessons>(Lessons(
            data = result.map {
                when (it) {
                    is FacultativeResponse -> {
                        Facultative(
                            id = it.id,
                            title = it.title,
                            icon = it.icon,
                            scheduler = it.scheduler,
                            teacher = it.teacher,
                            tagIconOne = it.tagIconOne,
                            tagIconTwo = it.tagIconTwo,
                            tagIconThree = it.tagIconThree,
                            description = it.description,
                            isTop = it.isTop
                        )
                    }
                    is LessonResponse -> {
                        Lesson(
                            id = it.id,
                            title = it.title,
                            icon = it.icon,
                            scheduler = it.scheduler,
                            useRemote = it.useRemote,
                            teacher = it.teacher,
                            isTop = it.isTop
                        )
                    }
                    else -> {
                        throw Exception("Unknown type")
                    }
                }
            }
        ))
    }

    override suspend fun getHomeWork(): AppState<HomeWorks> {
        val result = mockGetHomWork()
        return AppState.Success<HomeWorks>(HomeWorks(
            data = result.map {
                HomeWork(
                    id = it.id,
                    title = it.title,
                    icon = it.icon,
                    deadLine = it.deadLine,
                    work = it.work,
                    tagIconOne = tags.first(),
                    tagIconTwo = tags.last()
                )
            }
        ))
    }

    override suspend fun getExamDate(): AppState<Exam> {
        val result = mockGetExam()
        return AppState.Success<Exam>(
            Exam(
                date = result.date
            )
        )
    }
}