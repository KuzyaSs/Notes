package tech.ermakov.notes.features.notes.ui.noteEditor.model

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Stable
import kotlinx.datetime.format
import tech.ermakov.notes.core.ui.model.UiText
import tech.ermakov.notes.core.utils.currentLocalDateTime
import tech.ermakov.notes.core.utils.monthNumberSlashDayFormat
import tech.ermakov.notes.features.folders.domain.model.ALL_NOTES_FOLDER_ID
import tech.ermakov.notes.features.notes.domain.model.NEW_NOTE_ID
import tech.ermakov.notes.features.notes.domain.model.Note
import tech.ermakov.notes.features.notes.domain.model.NoteContentEdit

@Stable
internal data class EditableNote(
    val id: Long,
    val folderId: Long,
    val titleTextField: TextFieldState,
    val bodyTextField: TextFieldState,
    val isTrashed: Boolean,
    val updateDate: UiText,
) {

    companion object {

        val Default: EditableNote
            get() = EditableNote(
                id = NEW_NOTE_ID,
                folderId = ALL_NOTES_FOLDER_ID,
                titleTextField = TextFieldState(),
                bodyTextField = TextFieldState(),
                isTrashed = false,
                updateDate = UiText.StringData(
                    value = currentLocalDateTime().format(
                        format = monthNumberSlashDayFormat,
                    ),
                ),
            )
    }
}


internal fun Note.toEditableNote(): EditableNote {
    return EditableNote(
        id = id,
        folderId = folderId,
        titleTextField = TextFieldState(initialText = title),
        bodyTextField = TextFieldState(initialText = body),
        isTrashed = isTrashed,
        updateDate = UiText.StringData(
            value = updateDate.format(format = monthNumberSlashDayFormat),
        ),
    )
}

internal fun EditableNote.toNoteContentEdit(): NoteContentEdit {
    return NoteContentEdit(
        id = id,
        folderId = folderId,
        title = titleTextField.text.toString(),
        body = bodyTextField.text.toString(),
    )
}
