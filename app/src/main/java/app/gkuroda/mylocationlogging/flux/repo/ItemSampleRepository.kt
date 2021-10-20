package app.gkuroda.mylocationlogging.flux.repo

import io.reactivex.rxjava3.core.Single

class ItemSampleRepository : SampleRepository {
    override fun getSampleIntItem(item: Int): Single<Int> {
        val new = item + 1
        return Single.just(new)
    }
}