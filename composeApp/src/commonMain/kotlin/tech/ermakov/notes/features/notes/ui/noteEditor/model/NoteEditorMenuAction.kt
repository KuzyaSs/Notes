package tech.ermakov.notes.features.notes.ui.noteEditor.model

import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.delete
import notes.composeapp.generated.resources.delete_permanently
import notes.composeapp.generated.resources.ic_move
import notes.composeapp.generated.resources.ic_restore
import notes.composeapp.generated.resources.ic_trash
import notes.composeapp.generated.resources.move
import notes.composeapp.generated.resources.restore
import org.jetbrains.compose.resources.DrawableResource
import tech.ermakov.notes.core.ui.model.MenuAction
import tech.ermakov.notes.core.ui.model.UiText

/**
 * Actions with a note in the editor screen.
 */
internal enum class NoteEditorMenuAction(
    val text: UiText,
    val drawableRes: DrawableResource,
) {
    MOVE(
        text = UiText.StringRes(id = Res.string.move),
        drawableRes = Res.drawable.ic_move,
    ),
    DELETE(
        text = UiText.StringRes(id = Res.string.delete),
        drawableRes = Res.drawable.ic_trash,
    ),
    DELETE_PERMANENTLY(
        text = UiText.StringRes(id = Res.string.delete_permanently),
        drawableRes = Res.drawable.ic_trash,
    ),
    RESTORE(
        text = UiText.StringRes(id = Res.string.restore),
        drawableRes = Res.drawable.ic_restore,
    ),
}

internal fun NoteEditorMenuAction.toMenuAction(): MenuAction {
    return MenuAction(
        id = this.name,
        text = text,
        leadingIcon = drawableRes,
    )
}
