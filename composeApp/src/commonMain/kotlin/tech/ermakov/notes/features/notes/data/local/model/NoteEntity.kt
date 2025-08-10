package tech.ermakov.notes.features.notes.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import tech.ermakov.notes.features.folders.data.local.model.FolderEntity
import tech.ermakov.notes.features.notes.domain.model.NewNote
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Entity(
    tableName = "note",
    foreignKeys = [
        ForeignKey(
            entity = FolderEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("folder_id"),
            onDelete = ForeignKey.SET_NULL,
            onUpdate = ForeignKey.NO_ACTION
        )
    ],
)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "folder_id")
    val folderId: Long? = null,

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

internal fun NewNote.toNoteEntity(): NoteEntity = NoteEntity(
    folderId = folderId,
    title = title,
    content = content,
)
