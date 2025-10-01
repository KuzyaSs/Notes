package tech.ermakov.notes.features.notes.ui.noteEditor.model

internal sealed interface NoteEditorAction {

    object OnBackClick : NoteEditorAction
}
