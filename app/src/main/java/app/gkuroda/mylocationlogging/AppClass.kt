package app.gkuroda.mylocationlogging

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppClass : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return app.gkuroda.mylocationlogging.dagger.DaggerApplicationComponent.factory().create(this)
    }
}