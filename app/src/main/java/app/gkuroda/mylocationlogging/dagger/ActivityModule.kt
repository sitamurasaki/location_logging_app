package app.gkuroda.mylocationlogging.dagger

import app.gkuroda.mylocationlogging.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}