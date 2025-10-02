package tech.ermakov.notes.features.notes.ui.noteEditor.model

import androidx.compose.runtime.Stable
import tech.ermakov.notes.core.ui.model.MenuAction
import tech.ermakov.notes.features.notes.domain.model.NEW_NOTE_ID

@Stable
internal data class NoteEditorUiState(
    val note: EditableNote,
    val isLoading: Boolean = true,
    val isBacking: Boolean = false,
) {

    val isEditEnabled: Boolean
        get() = !isLoading && !isBacking && !note.isTrashed

    fun getMenuActions(): List<MenuAction> {
        return buildList {
            if (note.isTrashed) {
                add(NoteEditorMenuAction.DELETE_PERMANENTLY)
                add(NoteEditorMenuAction.RESTORE)
            } else {
                if (note.id != NEW_NOTE_ID) {
                    add(NoteEditorMenuAction.MOVE)
                }
                add(NoteEditorMenuAction.DELETE)
            }
        }.map(NoteEditorMenuAction::toMenuAction)
    }
}
