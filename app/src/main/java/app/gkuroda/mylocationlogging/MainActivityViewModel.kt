package app.gkuroda.mylocationlogging

import android.util.Log
import androidx.lifecycle.ViewModel
import app.gkuroda.mylocationlogging.flux.action.SampleActionCreatable
import app.gkuroda.mylocationlogging.flux.store.StoreInterface
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val store: StoreInterface,
    private val sampleActionCreator: SampleActionCreatable
) : ViewModel() {
    private val disposable = CompositeDisposable()

    init {
        subscribeStore()
    }

    fun requestSample(item: Int) {
        sampleActionCreator.getSampleIntItem(item)
    }

    private fun subscribeStore() {
        store.sampleIntItem
            .subscribe {
                Log.e("tag", "$it")
            }
            .addTo(disposable)
    }
}