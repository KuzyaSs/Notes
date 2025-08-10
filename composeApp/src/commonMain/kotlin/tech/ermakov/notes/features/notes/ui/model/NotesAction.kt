package tech.ermakov.notes.features.notes.ui.model

internal sealed interface NotesAction {

    data object OnAddClick : NotesAction
}
