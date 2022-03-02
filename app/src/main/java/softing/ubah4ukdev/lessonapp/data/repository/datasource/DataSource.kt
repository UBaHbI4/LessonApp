package softing.ubah4ukdev.lessonapp.data.repository.datasource

import softing.ubah4ukdev.lessonapp.domain.AppState
import softing.ubah4ukdev.lessonapp.domain.models.Exam
import softing.ubah4ukdev.lessonapp.domain.models.HomeWorks
import softing.ubah4ukdev.lessonapp.domain.models.Lessons

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
interface DataSource {
    suspend fun getLessons(): AppState<Lessons>
    suspend fun getHomeWork(): AppState<HomeWorks>
    suspend fun getExamDate(): AppState<Exam>
}