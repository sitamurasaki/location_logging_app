package app.gkuroda.mylocationlogging.flux.store

import app.gkuroda.mylocationlogging.flux.Dispatcher
import app.gkuroda.mylocationlogging.flux.action.SampleAction
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.kotlin.addTo

interface SampleStore {
    val sampleIntItem: BehaviorRelay<Int>
}

fun Store.subscribeSampleStore(dispatcher: Dispatcher) {
    dispatcher.onImpl<SampleAction.GetSampleIntItem>()
        .map { it.result }
        .subscribe(sampleIntItem::accept)
        .addTo(disposable)
}