package tech.ermakov.notes.features.notes.domain.model

data class NewNote(
    val folderId: Long?,
    val title: String,
    val content: String,
)
