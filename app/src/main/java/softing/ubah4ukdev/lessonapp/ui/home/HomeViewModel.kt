package softing.ubah4ukdev.lessonapp.ui.home

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import softing.ubah4ukdev.lessonapp.domain.AppState
import softing.ubah4ukdev.lessonapp.domain.models.ExamTime
import softing.ubah4ukdev.lessonapp.domain.models.Response
import softing.ubah4ukdev.lessonapp.domain.usecases.GetExamUseCase
import softing.ubah4ukdev.lessonapp.domain.usecases.GetHomeWorkUseCase
import softing.ubah4ukdev.lessonapp.domain.usecases.GetLessonUseCase
import softing.ubah4ukdev.lessonapp.utils.extensions.dateBetween
import softing.ubah4ukdev.mymovies.ui.base.BaseViewModel

class HomeViewModel(
    private val lessonsLiveData: MutableLiveData<AppState<Response>>
    = MutableLiveData<AppState<Response>>(),
    private val countdownLiveData: MutableLiveData<AppState<ExamTime>>
    = MutableLiveData<AppState<ExamTime>>(),
    private val getLessonUseCase: GetLessonUseCase,
    private val getHomeWorkUseCase: GetHomeWorkUseCase,
    private val getExamUseCase: GetExamUseCase
) : BaseViewModel() {

    fun getLessonsLiveData() = lessonsLiveData
    fun getCountDownLiveData() = countdownLiveData

    fun getData(): Job =
        viewModelScopeCoroutine.launch {
            getLessons().join()
            delay(DELAY)
            getHomeWork().join()
            delay(DELAY)
            getExam()
        }

    fun clear() {
        viewModelScopeCoroutine.cancel()
    }

    private fun countDown(dateExam: String): Job =
        viewModelScopeCoroutine.launch {
            while (true) {
                val result = dateBetween(dateExam)
                result?.let {
                    getCountDownLiveData().postValue(AppState.Success(it))
                }
                delay(EXAM_UPDATE_DELAY)
            }
        }

    private fun getLessons(): Job =
        viewModelScopeCoroutine.launch {
            getLessonsLiveData().postValue(
                getLessonUseCase.execute()
            )
        }

    private fun getHomeWork(): Job =
        viewModelScopeCoroutine.launch {
            getLessonsLiveData().postValue(
                getHomeWorkUseCase.execute()
            )
        }

    private fun getExam(): Job =
        viewModelScopeCoroutine.launch {
            this.coroutineContext.cancelChildren()
            val result = getExamUseCase.execute()
            if (result is AppState.Success) {
                countDown(result.data.date)
            }
        }

    override fun handleError(throwable: Throwable) {}

    companion object {
        private const val DELAY = 400L
        private const val EXAM_UPDATE_DELAY = 20000L
    }
}