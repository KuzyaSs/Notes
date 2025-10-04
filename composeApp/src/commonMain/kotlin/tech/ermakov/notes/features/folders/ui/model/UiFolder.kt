package tech.ermakov.notes.features.folders.ui.model

import androidx.compose.runtime.Immutable
import tech.ermakov.notes.core.ui.model.UiText

@Immutable
internal data class UiFolder(
    val id: Long,
    val name: UiText,
    val notesCount: Int,
)
