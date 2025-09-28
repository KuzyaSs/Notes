package tech.ermakov.notes.features.notes.ui.model

internal data class NotesUiState(
    val notes: List<UiNote> = emptyList(),
    val noteListType: UiNoteListType = UiNoteListType.LIST,
    val isLoading: Boolean = false,
)
