package tech.ermakov.notes.features.notes.ui.noteEditor.model

internal sealed interface NoteEditorAction {

    data object OnBackClick : NoteEditorAction

    data class OnMenuActionClick(
        val menuAction: NoteEditorMenuAction,
    ) : NoteEditorAction
}
