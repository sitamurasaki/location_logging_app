package app.gkuroda.mylocationlogging.dagger

import app.gkuroda.mylocationlogging.AppClass
import app.gkuroda.mylocationlogging.dagger.viewModel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        ApplicationModule::class,
        ViewModelModule::class
    ]
)

interface ApplicationComponent : AndroidInjector<AppClass> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<AppClass>

}