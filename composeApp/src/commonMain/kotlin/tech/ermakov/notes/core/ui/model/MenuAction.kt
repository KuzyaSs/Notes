package tech.ermakov.notes.core.ui.model

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.DrawableResource
import tech.ermakov.notes.core.ui.component.dropDownMenu.MenuActionItem
import tech.ermakov.notes.core.ui.component.dropDownMenu.NotesDropdownMenu

/**
 * An action that is used in the [MenuActionItem].
 *
 * @see [NotesDropdownMenu]
 */
@Immutable
data class MenuAction(
    val id: String,
    val text: UiText,
    val leadingIcon: DrawableResource,
)
