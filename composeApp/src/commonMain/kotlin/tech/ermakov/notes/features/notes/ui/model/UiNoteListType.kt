package tech.ermakov.notes.features.notes.ui.model

import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.ic_card_view
import notes.composeapp.generated.resources.ic_list_view
import org.jetbrains.compose.resources.DrawableResource
import tech.ermakov.notes.features.notes.domain.model.NoteListType

internal enum class UiNoteListType(
    val drawableRes: DrawableResource,
) {
    LIST(drawableRes = Res.drawable.ic_list_view),
    CARD(drawableRes = Res.drawable.ic_card_view),
}

internal fun NoteListType.toUiNoteListType(): UiNoteListType {
    return when (this) {
        NoteListType.LIST -> UiNoteListType.LIST
        NoteListType.CARD -> UiNoteListType.CARD
    }
}
