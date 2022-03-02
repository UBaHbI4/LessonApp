package softing.ubah4ukdev.lessonapp.ui.classes

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import softing.ubah4ukdev.lessonapp.domain.AppState
import softing.ubah4ukdev.lessonapp.domain.models.Response
import softing.ubah4ukdev.lessonapp.domain.usecases.GetLessonUseCase
import softing.ubah4ukdev.mymovies.ui.base.BaseViewModel

class ClassesViewModel(
    private val lessonsLiveData: MutableLiveData<AppState<Response>>
    = MutableLiveData<AppState<Response>>(),
    private val getLessonUseCase: GetLessonUseCase,
) : BaseViewModel() {

    fun getLessonsLiveData() = lessonsLiveData

    fun getLessons(): Job =
        viewModelScopeCoroutine.launch {
            getLessonsLiveData().postValue(
                getLessonUseCase.execute()
            )
        }

    override fun handleError(throwable: Throwable) {}
}