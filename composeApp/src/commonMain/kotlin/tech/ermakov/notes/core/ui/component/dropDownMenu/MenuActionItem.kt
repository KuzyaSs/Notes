package tech.ermakov.notes.core.ui.component.dropDownMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.ic_move
import notes.composeapp.generated.resources.move
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.model.MenuAction
import tech.ermakov.notes.core.ui.model.UiText
import tech.ermakov.notes.core.ui.theme.NotesTheme

@Composable
internal fun MenuActionItem(
    menuAction: MenuAction,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DropdownMenuItem(
        text = {
            Text(
                text = menuAction.text.asString(),
                color = NotesTheme.colors.textPrimary,
                style = NotesTheme.typography.body,
            )
        },
        onClick = onClick,
        leadingIcon = {
            Icon(
                painter = painterResource(resource = menuAction.leadingIcon),
                contentDescription = null,
                tint = NotesTheme.colors.textPrimary,
            )
        },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun MenuActionItemPreview() {
    NotesTheme {
        Box(
            modifier = Modifier.background(color = NotesTheme.colors.backgroundSecondary),
        ) {
            MenuActionItem(
                menuAction = MenuAction(
                    id = "",
                    text = UiText.StringRes(id = Res.string.move),
                    leadingIcon = Res.drawable.ic_move,
                ),
                onClick = { },
            )
        }
    }
}
