package tech.ermakov.notes.features.notes.ui.model

internal sealed interface NotesAction {

    data object OnToolbarClick : NotesAction

    data object OnNoteListTypeClick : NotesAction

    data object OnSettingsClick : NotesAction

    data object OnAddClick : NotesAction
}
