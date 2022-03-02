package softing.ubah4ukdev.lessonapp.domain.usecases

import softing.ubah4ukdev.lessonapp.domain.AppState
import softing.ubah4ukdev.lessonapp.domain.models.HomeWorks
import softing.ubah4ukdev.lessonapp.domain.repository.Repository

/**
 *   Project: City terminal
 *
 *   Package: softing.ubah4ukdev.cityterminal.domain.usecases.db2
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2022.01.23
 *
 *   v1.0
 */
class GetHomeWorkUseCase(private val repository: Repository) {
    suspend fun execute(): AppState<HomeWorks> =
        repository.getHomeWork()
}