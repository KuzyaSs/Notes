package tech.ermakov.notes.core.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

val monthNumberSlashDayFormat = LocalDateTime.Format {
    monthNumber()
    char('/')
    day()
}

@OptIn(ExperimentalTime::class)
fun currentLocalDateTime(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(timeZone = TimeZone.currentSystemDefault())
}
