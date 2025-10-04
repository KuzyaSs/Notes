package tech.ermakov.notes.features.notes.ui.notes.component

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
import notes.composeapp.generated.resources.ic_arrow_drop_down
import notes.composeapp.generated.resources.ic_settings
import notes.composeapp.generated.resources.notes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.folders.ui.component.TopToolbar
import tech.ermakov.notes.features.notes.ui.notes.model.UiNoteListType

@Composable
internal fun TopToolbar(
    noteListType: UiNoteListType,
    onTitleClick: () -> Unit,
    onNoteListTypeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { onTitleClick() },
                    )
                },
        ) {
            Text(
                text = stringResource(resource = Res.string.notes),
                color = NotesTheme.colors.textPrimary,
                style = NotesTheme.typography.display,
            )

            Icon(
                painter = painterResource(resource = Res.drawable.ic_arrow_drop_down),
                contentDescription = null,
                tint = NotesTheme.colors.textPrimary,
            )
        }

        Spacer(
            modifier = Modifier
                .weight(weight = 1f),
        )

        Icon(
            painter = painterResource(resource = noteListType.drawableRes),
            contentDescription = null,
            tint = NotesTheme.colors.textPrimary,
            modifier = Modifier
                .padding(end = 16.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { onNoteListTypeClick() },
                    )
                },
        )

        Icon(
            painter = painterResource(resource = Res.drawable.ic_settings),
            contentDescription = null,
            tint = NotesTheme.colors.textPrimary,
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { onSettingsClick() },
                    )
                },
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
                noteListType = UiNoteListType.CARD,
                onTitleClick = { },
                onNoteListTypeClick = { },
                onSettingsClick = { },
            )
        }
    }
}
