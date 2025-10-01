package tech.ermakov.notes.features.notes.ui.notes.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.ic_folder
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.notes.model.UiNote

@Composable
internal fun CardNoteItem(
    note: UiNote,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 128.dp)
            .background(
                color = NotesTheme.colors.backgroundPrimary,
                shape = RoundedCornerShape(size = NotesTheme.shapes.medium),
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onClick() },
                )
            }
            .padding(all = 16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_folder),
                contentDescription = null,
                tint = NotesTheme.colors.textSecondary,
                modifier = Modifier
                    .padding(end = 4.dp),
            )

            Text(
                text = note.folderName.asString(),
                style = NotesTheme.typography.body.copy(
                    color = NotesTheme.colors.textSecondary,
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(end = 8.dp),
            )

            Text(
                text = note.updateDate.asString(),
                style = NotesTheme.typography.body.copy(
                    color = NotesTheme.colors.textSecondary,
                ),
            )
        }

        Text(
            text = note.title.asString(),
            color = NotesTheme.colors.textPrimary,
            style = NotesTheme.typography.title,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}

@Preview
@Composable
private fun CardNoteItemPreview() {
    NotesTheme {
        CardNoteItem(
            note = UiNote.Default,
            onClick = { },
        )
    }
}
