package tech.ermakov.notes.features.notes.ui.notes.model

internal sealed interface NotesAction {

    data object OnToolbarClick : NotesAction

    data object OnNoteListTypeClick : NotesAction

    data object OnSettingsClick : NotesAction

    data class OnNoteClick(
        val noteId: Long,
    ) : NotesAction

    data object OnAddClick : NotesAction
}
