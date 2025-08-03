package tech.ermakov.notes.features.notes.domain

import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Int,
    val folderId: Int,
    val folderName: String,
    val title: String,
    val content: String,
    val createDate: LocalDateTime,
    val updateDate: LocalDateTime,
)
