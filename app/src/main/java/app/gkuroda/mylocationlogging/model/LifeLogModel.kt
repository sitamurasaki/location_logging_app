package app.gkuroda.mylocationlogging.model

import java.time.LocalDateTime

data class LifeLogModel (
    val timeStamp:LocalDateTime,
    val lat:Float,
    val lng:Float,

)