package tech.ermakov.notes.features.notes.domain.model

/**
 * An entity used to update the note content after editing.
 */
data class NoteContentEdit(
    val id: Long,
    val folderId: Long,
    val title: String,
    val body: String,
)

fun NoteContentEdit.toNote(): Note {
    return Note(
        id = id,
        folderId = folderId,
        folderName = "",
        title = title,
        body = body,
        isTrashed = false,
    )
}
