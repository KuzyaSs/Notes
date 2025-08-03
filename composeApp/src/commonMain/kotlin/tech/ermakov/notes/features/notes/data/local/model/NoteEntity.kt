package tech.ermakov.notes.features.notes.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "folder_id")
    val folderId: Int,

    val title: String,

    val content: String,

    @ColumnInfo(name = "create_date")
    val createDate: LocalDateTime = Clock.System.now()
        .toLocalDateTime(timeZone = TimeZone.currentSystemDefault()),

    @ColumnInfo(name = "update_date")
    val updateDate: LocalDateTime = Clock.System.now()
        .toLocalDateTime(timeZone = TimeZone.currentSystemDefault()),

    @ColumnInfo(name = "is_trashed")
    val isTrashed: Boolean = false,
)
