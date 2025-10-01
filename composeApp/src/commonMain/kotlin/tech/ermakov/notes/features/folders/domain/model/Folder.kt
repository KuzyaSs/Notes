package tech.ermakov.notes.features.folders.domain.model

const val ALL_NOTES_FOLDER_ID: Long = -1
const val TRASH_FOLDER_ID: Long = -2

data class Folder(
    val id: Long,
    val name: String,
    val notesCount: Int,
)
