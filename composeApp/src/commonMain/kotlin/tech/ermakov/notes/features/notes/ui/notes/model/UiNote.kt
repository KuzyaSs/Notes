package tech.ermakov.notes.features.notes.ui.notes.model

import androidx.compose.runtime.Immutable
import kotlinx.datetime.format
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.all_notes_folder
import notes.composeapp.generated.resources.trash_folder
import tech.ermakov.notes.core.ui.model.UiText
import tech.ermakov.notes.core.utils.currentLocalDateTime
import tech.ermakov.notes.core.utils.monthNumberSlashDayFormat
import tech.ermakov.notes.features.folders.domain.model.ALL_NOTES_FOLDER_ID
import tech.ermakov.notes.features.folders.domain.model.TRASH_FOLDER_ID
import tech.ermakov.notes.features.notes.domain.model.NEW_NOTE_ID
import tech.ermakov.notes.features.notes.domain.model.Note

@Immutable
internal data class UiNote(
    val id: Long,
    val folderId: Long,
    val folderName: UiText,
    val title: UiText,
    val body: UiText,
    val isTrashed: Boolean,
    val updateDate: UiText,
) {

    companion object {

        val Default: UiNote
            get() = UiNote(
                id = NEW_NOTE_ID,
                folderId = ALL_NOTES_FOLDER_ID,
                folderName = UiText.StringData(value = "Folder #1"),
                title = UiText.StringData(value = "Some title"),
                body = UiText.StringData(value = "Some body content"),
                isTrashed = false,
                updateDate = UiText.StringData(
                    value = currentLocalDateTime().format(
                        format = monthNumberSlashDayFormat,
                    ),
                ),
            )
    }
}


internal fun Note.toUiNote(): UiNote {
    return UiNote(
        id = id,
        folderId = folderId,
        folderName = when (folderId) {
            ALL_NOTES_FOLDER_ID -> UiText.StringRes(id = Res.string.all_notes_folder)
            TRASH_FOLDER_ID -> UiText.StringRes(id = Res.string.trash_folder)
            else -> UiText.StringData(value = folderName)
        },
        title = UiText.StringData(value = title.ifBlank { body }),
        body = UiText.StringData(value = body),
        isTrashed = isTrashed,
        updateDate = UiText.StringData(
            value = updateDate.format(format = monthNumberSlashDayFormat),
        ),
    )
}
