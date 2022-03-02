package softing.ubah4ukdev.lessonapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import softing.ubah4ukdev.lessonapp.data.repository.RepositoryImpl
import softing.ubah4ukdev.lessonapp.data.repository.datasource.DataSource
import softing.ubah4ukdev.lessonapp.data.repository.datasource.MockDataSourceImpl
import softing.ubah4ukdev.lessonapp.domain.repository.Repository
import softing.ubah4ukdev.lessonapp.domain.usecases.GetExamUseCase
import softing.ubah4ukdev.lessonapp.domain.usecases.GetHomeWorkUseCase
import softing.ubah4ukdev.lessonapp.domain.usecases.GetLessonUseCase
import softing.ubah4ukdev.lessonapp.ui.classes.ClassesViewModel
import softing.ubah4ukdev.lessonapp.ui.favourite.FavouriteViewModel
import softing.ubah4ukdev.lessonapp.ui.home.HomeViewModel
import softing.ubah4ukdev.lessonapp.ui.list.ListViewModel

/**
 *   Project: LessonApp
 *
 *   Package: softing.ubah4ukdev.lessonapp.di
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
object Di {

    fun viewModelModule() = module {
        viewModel() {
            ClassesViewModel(
                getLessonUseCase = get()
            )
        }

        viewModel() {
            FavouriteViewModel()
        }

        viewModel() {
            HomeViewModel(
                getLessonUseCase = get(),
                getHomeWorkUseCase = get(),
                getExamUseCase = get()
            )
        }

        viewModel() {
            ListViewModel()
        }
    }

    fun useCasesModule() = module {
        factory<GetLessonUseCase> {
            GetLessonUseCase(repository = get())
        }
        factory<GetHomeWorkUseCase> {
            GetHomeWorkUseCase(repository = get())
        }
        factory<GetExamUseCase> {
            GetExamUseCase(repository = get())
        }
    }

    fun repositoryModule() = module {
        single<Repository>() {
            RepositoryImpl(
                dataSource = get()
            )
        }

        single<DataSource> {
            MockDataSourceImpl()
        }
    }
}