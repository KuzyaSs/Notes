package tech.ermakov.notes.features.notes.models

import tech.ermakov.notes.features.notes.domain.Note

internal data class NotesUiState(
    val notes: List<Note>
)
