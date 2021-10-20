package app.gkuroda.mylocationlogging.dagger.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val provider: Provider<ViewModel> = providers[modelClass] ?: run {
            providers.keys.find { key ->
                modelClass.isAssignableFrom(key)
            }?.let { key ->
                providers[key]
            }
        } ?: run {
            throw IllegalArgumentException("model class unkown : $modelClass")
        }

        try {
            return provider.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

    inline fun <reified T : ViewModel> get(viewModelStoreOwner: ViewModelStoreOwner): T =
        ViewModelProvider(viewModelStoreOwner, this).get(T::class.java)
}