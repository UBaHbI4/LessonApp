package softing.ubah4ukdev.lessonapp.data.repository

import softing.ubah4ukdev.lessonapp.data.repository.datasource.DataSource
import softing.ubah4ukdev.lessonapp.domain.AppState
import softing.ubah4ukdev.lessonapp.domain.models.Exam
import softing.ubah4ukdev.lessonapp.domain.models.HomeWorks
import softing.ubah4ukdev.lessonapp.domain.models.Lessons
import softing.ubah4ukdev.lessonapp.domain.repository.Repository

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
class RepositoryImpl(private val dataSource: DataSource) : Repository {
    override suspend fun getLessons(): AppState<Lessons> =
        dataSource.getLessons()

    override suspend fun getHomeWork(): AppState<HomeWorks> =
        dataSource.getHomeWork()

    override suspend fun getExamDate(): AppState<Exam> =
        dataSource.getExamDate()
}