package app.gkuroda.mylocationlogging.dagger

import android.content.Context
import app.gkuroda.mylocationlogging.AppClass
import app.gkuroda.mylocationlogging.flux.Dispatcher
import app.gkuroda.mylocationlogging.flux.action.SampleActionCreatable
import app.gkuroda.mylocationlogging.flux.action.SampleActionCreator
import app.gkuroda.mylocationlogging.flux.repo.ItemSampleRepository
import app.gkuroda.mylocationlogging.flux.repo.SampleRepository
import app.gkuroda.mylocationlogging.flux.store.Store
import app.gkuroda.mylocationlogging.flux.store.StoreInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    fun context(application: AppClass): Context = application

    @Singleton
    @Provides
    fun store(dispatcher: Dispatcher): StoreInterface = Store(dispatcher)

    @Provides
    fun sampleActionCreator(
        dispatcher: Dispatcher,
        sampleRepository: SampleRepository
    ): SampleActionCreatable = SampleActionCreator(dispatcher, sampleRepository)

    @Singleton
    @Provides
    fun sampleRepository(): SampleRepository = ItemSampleRepository()
}