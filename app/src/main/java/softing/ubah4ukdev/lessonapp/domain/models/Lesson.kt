package softing.ubah4ukdev.lessonapp.domain.models

/**
 *   Project: LessonApp
 *
 *   Package: softing.ubah4ukdev.lessonapp.data.models
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
data class Lesson(
    val id: Int,
    val title: String,
    val icon: String,
    val scheduler: Schedulers,
    val teacher: String,
    val useRemote: Boolean = false,
    val isTop: Boolean = false
) : Lessonable