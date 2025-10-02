package tech.ermakov.notes.core.ui.component.dropDownMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.model.MenuAction
import tech.ermakov.notes.core.ui.theme.NotesTheme

@Composable
fun NotesDropdownMenu(
    menuActions: List<MenuAction>,
    isExpanded: Boolean,
    onMenuActionClick: (menuActionId: String) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = onDismissRequest,
        shape = NotesTheme.shapes.small,
        containerColor = NotesTheme.colors.backgroundPrimary,
        modifier = modifier,
    ) {
        menuActions.forEach { menuAction ->
            MenuActionItem(
                menuAction = menuAction,
                onClick = {
                    onMenuActionClick(menuAction.id)
                },
            )
        }
    }
}

@Preview
@Composable
private fun DropdownMenuPreview() {
    NotesTheme {
        Box(
            modifier = Modifier.background(color = NotesTheme.colors.backgroundSecondary),
        ) {
            NotesDropdownMenu(
                menuActions = emptyList(),
                isExpanded = true,
                onMenuActionClick = { },
                onDismissRequest = { },
            )
        }
    }
}
