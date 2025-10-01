package tech.ermakov.notes.features.notes.ui.noteEditor.model

import androidx.compose.runtime.Stable

@Stable
internal data class NoteEditorUiState(
    val note: EditableNote,
    val isLoading: Boolean = true,
    val isSaving: Boolean = false,
)
