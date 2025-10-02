package tech.ermakov.notes.features.notes.ui.noteEditor.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.ic_more_vert
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.component.dropDownMenu.NotesDropdownMenu
import tech.ermakov.notes.core.ui.model.MenuAction
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorMenuAction

@Composable
internal fun MoreIcon(
    menuActions: List<MenuAction>,
    onMenuActionClick: (menuAction: NoteEditorMenuAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isDropDownMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(resource = Res.drawable.ic_more_vert),
            contentDescription = null,
            tint = NotesTheme.colors.textPrimary,
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { isDropDownMenuVisible = true },
                    )
                },
        )

        NotesDropdownMenu(
            menuActions = menuActions,
            isExpanded = isDropDownMenuVisible,
            onMenuActionClick = { menuActionId ->
                isDropDownMenuVisible = false
                onMenuActionClick(NoteEditorMenuAction.valueOf(menuActionId))
            },
            onDismissRequest = {
                isDropDownMenuVisible = false
            },
        )
    }
}

@Preview
@Composable
private fun MoreIconPreview() {
    NotesTheme {
        Box(
            modifier = Modifier.background(color = NotesTheme.colors.backgroundSecondary),
        ) {
            MoreIcon(
                menuActions = emptyList(),
                onMenuActionClick = { },
            )
        }
    }
}
