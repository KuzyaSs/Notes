package tech.ermakov.notes.features.notes.domain.model

import kotlinx.datetime.LocalDateTime
import tech.ermakov.notes.core.utils.currentLocalDateTime

const val NEW_NOTE_ID: Long = 0

data class Note(
    val id: Long,
    val folderId: Long,
    val folderName: String,
    val title: String,
    val body: String,
    val isTrashed: Boolean,
    val updateDate: LocalDateTime = currentLocalDateTime(),
    val createDate: LocalDateTime = currentLocalDateTime(),
)
