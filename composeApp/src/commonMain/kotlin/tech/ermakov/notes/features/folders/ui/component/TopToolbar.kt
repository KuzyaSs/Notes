package tech.ermakov.notes.features.folders.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.folders
import notes.composeapp.generated.resources.ic_arrow_drop_up
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.theme.NotesTheme

@Composable
internal fun TopToolbar(
    onTitleClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onTitleClick() },
                )
            },
    ) {
        Text(
            text = stringResource(resource = Res.string.folders),
            color = NotesTheme.colors.textPrimary,
            style = NotesTheme.typography.display,
        )

        Icon(
            painter = painterResource(resource = Res.drawable.ic_arrow_drop_up),
            contentDescription = null,
            tint = NotesTheme.colors.textPrimary,
        )
    }
}

@Preview
@Composable
private fun TopToolbarPreview() {
    NotesTheme {
        Box(
            modifier = Modifier
                .background(color = NotesTheme.colors.backgroundSecondary),
        ) {
            TopToolbar(
                onTitleClick = { },
            )
        }
    }
}
