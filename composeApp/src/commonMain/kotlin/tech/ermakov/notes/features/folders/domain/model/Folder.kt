package tech.ermakov.notes.features.folders.domain.model

data class Folder(
    val id: Int,
    val title: String,
    val notesCount: Int,
)
