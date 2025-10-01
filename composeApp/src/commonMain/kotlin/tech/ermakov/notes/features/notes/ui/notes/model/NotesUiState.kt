package tech.ermakov.notes.features.notes.ui.notes.model

import androidx.compose.runtime.Immutable

@Immutable
internal data class NotesUiState(
    val notes: List<UiNote> = emptyList(),
    val noteListType: UiNoteListType = UiNoteListType.LIST,
    val isLoading: Boolean = false,
)
