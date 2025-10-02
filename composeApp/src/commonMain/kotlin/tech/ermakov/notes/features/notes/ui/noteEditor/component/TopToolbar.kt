package tech.ermakov.notes.features.notes.ui.noteEditor.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.ic_arrow_back
import notes.composeapp.generated.resources.notes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.model.MenuAction
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorMenuAction

@Composable
internal fun TopToolbar(
    menuActions: List<MenuAction>,
    onMenuActionClick: (menuAction: NoteEditorMenuAction) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(resource = Res.drawable.ic_arrow_back),
            contentDescription = null,
            tint = NotesTheme.colors.textPrimary,
            modifier = Modifier
                .padding(end = 8.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { onBackClick() },
                    )
                },
        )

        Text(
            text = stringResource(resource = Res.string.notes),
            color = NotesTheme.colors.textPrimary,
            style = NotesTheme.typography.headline,
        )

        Spacer(
            modifier = Modifier
                .weight(weight = 1f),
        )

        MoreIcon(
            menuActions = menuActions,
            onMenuActionClick = onMenuActionClick,
            modifier = Modifier
                .padding(end = 8.dp),
        )
    }
}



@Preview
@Composable
private fun TopToolbarPreview() {
    NotesTheme {
        Box(
            modifier = Modifier.background(color = NotesTheme.colors.backgroundSecondary),
        ) {
            TopToolbar(
                menuActions = emptyList(),
                onMenuActionClick = { },
                onBackClick = { },
            )
        }
    }
}
