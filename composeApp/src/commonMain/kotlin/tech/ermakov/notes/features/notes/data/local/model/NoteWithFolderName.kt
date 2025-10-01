package tech.ermakov.notes.features.notes.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import tech.ermakov.notes.features.notes.domain.model.Note

data class NoteWithFolderName(
    @Embedded
    val noteEntity: NoteEntity,
    @ColumnInfo(name = "folder_name")
    val folderName: String?,
)

internal fun NoteWithFolderName.toNote(): Note = Note(
    id = noteEntity.id,
    folderId = noteEntity.folderId,
    folderName = folderName.orEmpty(),
    title = noteEntity.title,
    body = noteEntity.body,
    isTrashed = noteEntity.isTrashed,
    updateDate = noteEntity.updateDate,
    createDate = noteEntity.createDate,
)
