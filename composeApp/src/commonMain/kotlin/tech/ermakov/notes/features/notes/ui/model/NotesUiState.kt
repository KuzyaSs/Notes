package tech.ermakov.notes.features.notes.ui.model

import tech.ermakov.notes.features.notes.domain.model.Note

internal data class NotesUiState(
    val notes: List<Note> = emptyList(),
    val noteListType: NoteListType = NoteListType.LIST,
    val isLoading: Boolean = false,
)
