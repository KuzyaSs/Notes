package tech.ermakov.notes.features.folders.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import tech.ermakov.notes.features.folders.domain.model.Folder

data class FolderWithNotesCount(
    @Embedded
    val folderEntity: FolderEntity,

    @ColumnInfo(name = "notes_count")
    val notesCount: Int,
)

internal fun FolderWithNotesCount.toFolder(): Folder = Folder(
    id = folderEntity.id,
    name = folderEntity.name,
    notesCount = notesCount,
)
