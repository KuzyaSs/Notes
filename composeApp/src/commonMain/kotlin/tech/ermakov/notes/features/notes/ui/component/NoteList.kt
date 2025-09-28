package tech.ermakov.notes.features.notes.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.model.UiNote
import tech.ermakov.notes.features.notes.ui.model.UiNote.Companion.previewNote

@Composable
internal fun NoteList(
    notes: List<UiNote>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 16.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        modifier = modifier,
    ) {
        items(items = notes) { note ->
            ListNoteItem(
                note = note,
            )
        }
    }
}

@Preview
@Composable
private fun NoteListPreview() {
    NotesTheme {
        NoteList(
            notes = buildList {
                repeat(5) { add(previewNote) }
            },
        )
    }
}
