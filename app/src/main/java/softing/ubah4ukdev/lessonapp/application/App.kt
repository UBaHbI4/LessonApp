package softing.ubah4ukdev.lessonapp.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import softing.ubah4ukdev.lessonapp.di.Di

/**
 *   Project: LessonApp
 *
 *   Package: softing.ubah4ukdev.lessonapp.application
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
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    Di.viewModelModule(),
                    Di.useCasesModule(),
                    Di.repositoryModule()
                )
            )
        }
    }
}