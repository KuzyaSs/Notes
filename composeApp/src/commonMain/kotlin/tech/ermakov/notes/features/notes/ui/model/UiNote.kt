package tech.ermakov.notes.features.notes.ui.model

import androidx.compose.runtime.Immutable
import kotlinx.datetime.format
import tech.ermakov.notes.core.ui.model.UiText
import tech.ermakov.notes.core.utils.currentLocalDateTime
import tech.ermakov.notes.core.utils.monthNumberSlashDayFormat

@Immutable
internal data class UiNote(
    val id: Long,
    val folderId: Long?,
    val folderName: UiText,
    val title: UiText,
    val content: UiText,
    val updateDate: UiText,
) {

    companion object {

        val previewNote = UiNote(
            id = 0,
            folderId = null,
            folderName = UiText.StringData(value = "Folder #1"),
            title = UiText.StringData(value = "Some title"),
            content = UiText.StringData(value = "Some content"),
            updateDate = UiText.StringData(
                value = currentLocalDateTime().format(
                    format = monthNumberSlashDayFormat,
                ),
            ),
        )
    }
}
