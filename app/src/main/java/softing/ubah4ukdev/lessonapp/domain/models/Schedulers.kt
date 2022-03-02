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
data class Schedulers(
    val start: String,
    val end: String
) {
    override fun toString(): String = "$start - $end"
}