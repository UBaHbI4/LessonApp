package softing.ubah4ukdev.lessonapp.data.models

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
data class HomeWorkResponse(
    val id: Int,
    val title: String,
    val icon: String,
    val deadLine: String,
    val work: String,
    val tagIconOne: String,
    val tagIconTwo: String
)