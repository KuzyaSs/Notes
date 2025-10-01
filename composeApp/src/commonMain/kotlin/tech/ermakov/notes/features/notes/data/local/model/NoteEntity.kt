package tech.ermakov.notes.features.notes.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import tech.ermakov.notes.core.utils.currentLocalDateTime
import tech.ermakov.notes.features.notes.domain.model.Note
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Entity(
    tableName = "note",
)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "folder_id")
    val folderId: Long,

    val title: String,

    val body: String,

    @ColumnInfo(name = "is_trashed")
    val isTrashed: Boolean = false,

    @ColumnInfo(name = "update_date")
    val updateDate: LocalDateTime = currentLocalDateTime(),

    @ColumnInfo(name = "create_date")
    val createDate: LocalDateTime = currentLocalDateTime(),
)

internal fun Note.toNoteEntity(): NoteEntity = NoteEntity(
    id = id,
    folderId = folderId,
    title = title,
    body = body,
    isTrashed = isTrashed,
    updateDate = updateDate,
    createDate = createDate,
)
