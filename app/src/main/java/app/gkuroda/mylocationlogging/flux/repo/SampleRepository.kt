package app.gkuroda.mylocationlogging.flux.repo

import io.reactivex.rxjava3.core.Single

interface SampleRepository {
    fun getSampleIntItem(item: Int): Single<Int>
}