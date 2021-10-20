package app.gkuroda.mylocationlogging.flux.store

import app.gkuroda.mylocationlogging.flux.Dispatcher
import app.gkuroda.mylocationlogging.flux.action.Action
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class Store(private val dispatcher: Dispatcher) : StoreInterface {

    val reducerThread: Scheduler = Schedulers.computation()

    val disposable = CompositeDisposable()

    override val sampleIntItem: BehaviorRelay<Int> = BehaviorRelay.create()

    init {
        subscribe()
    }

    private fun subscribe() {
        subscribeSampleStore(dispatcher)
    }

    inline fun <reified T : Action> Dispatcher.onImpl(): Flowable<T> =
        on<T>().observeOn(reducerThread)

}