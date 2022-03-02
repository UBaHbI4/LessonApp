package softing.ubah4ukdev.lessonapp.domain.models

/**
 *   Project: LessonApp
 *
 *   Package: softing.ubah4ukdev.lessonapp.domain.models
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2022.03.01
 *
 *   v1.0
 */
data class ExamTime(
    val dayFirst: String,
    val daySecond: String,
    val hourFirst: String,
    val hourSecond: String,
    val minuteFirst: String,
    val minuteSecond: String
) : Response