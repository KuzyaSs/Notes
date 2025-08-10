package tech.ermakov.notes.features.folders.domain.model

data class Folder(
    val id: Long,
    val name: String,
    val notesCount: Int,
)
