package tech.ermakov.notes.features.notes.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.model.UiNote
import tech.ermakov.notes.features.notes.ui.model.UiNote.Companion.previewNote

@Composable
internal fun NoteGrid(
    notes: List<UiNote>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 300.dp),
        contentPadding = PaddingValues(
            vertical = 16.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
        modifier = modifier,
    ) {
        items(items = notes) { note ->
            CardNoteItem(
                note = note,
            )
        }
    }
}

@Preview
@Composable
private fun NoteGridPreview() {
    NotesTheme {
        NoteGrid(
            notes = buildList {
                repeat(5) { add(previewNote) }
            },
        )
    }
}
