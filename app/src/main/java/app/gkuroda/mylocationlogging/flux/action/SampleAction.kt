package app.gkuroda.mylocationlogging.flux.action

sealed class SampleAction : Action {
    class GetSampleIntItem(val result: Int) : SampleAction()
}