package app.gkuroda.mylocationlogging.dagger.viewModel

import androidx.lifecycle.ViewModel
import app.gkuroda.mylocationlogging.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

}