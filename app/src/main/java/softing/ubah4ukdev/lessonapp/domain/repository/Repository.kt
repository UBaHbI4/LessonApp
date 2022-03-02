package softing.ubah4ukdev.lessonapp.domain.repository

import softing.ubah4ukdev.lessonapp.domain.AppState
import softing.ubah4ukdev.lessonapp.domain.models.Exam
import softing.ubah4ukdev.lessonapp.domain.models.HomeWorks
import softing.ubah4ukdev.lessonapp.domain.models.Lessons

/**
 *   Project: LessonApp
 *
 *   Package: softing.ubah4ukdev.lessonapp.domain.repository
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
interface Repository {
    suspend fun getLessons(): AppState<Lessons>
    suspend fun getHomeWork(): AppState<HomeWorks>
    suspend fun getExamDate(): AppState<Exam>
}