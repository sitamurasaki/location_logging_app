package app.gkuroda.mylocationlogging.flux.action

import app.gkuroda.mylocationlogging.flux.Dispatcher
import app.gkuroda.mylocationlogging.flux.LifecycleSensitiveActionCreator
import app.gkuroda.mylocationlogging.flux.repo.SampleRepository
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SampleActionCreator(
    private val dispatcher: Dispatcher,
    private val sampleRepository: SampleRepository
) : LifecycleSensitiveActionCreator(), SampleActionCreatable {
    override fun getSampleIntItem(item: Int) {
        sampleRepository.getSampleIntItem(item)
            .subscribeOn(Schedulers.io())
            .map(SampleAction::GetSampleIntItem)
            .subscribe(dispatcher::dispatch)
            .addTo(disposable)
    }
}