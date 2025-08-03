package tech.ermakov.notes.core.database.converter

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class DateTimeConverter {

    @OptIn(ExperimentalTime::class)
    @TypeConverter
    fun localDateTimeToTimestamp(dateTime: LocalDateTime): Long {
        return dateTime
            .toInstant(timeZone = TimeZone.currentSystemDefault())
            .toEpochMilliseconds()
    }

    @OptIn(ExperimentalTime::class)
    @TypeConverter
    fun timestampToLocalDateTime(timestamp: Long): LocalDateTime {
        return Instant
            .fromEpochMilliseconds(epochMilliseconds = timestamp)
            .toLocalDateTime(timeZone = TimeZone.currentSystemDefault())
    }
}
