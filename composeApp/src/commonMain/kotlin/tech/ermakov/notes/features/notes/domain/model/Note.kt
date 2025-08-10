package tech.ermakov.notes.features.notes.domain.model

import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long,
    val folderId: Long?,
    val folderName: String,
    val title: String,
    val content: String,
    val createDate: LocalDateTime,
    val updateDate: LocalDateTime,
)
