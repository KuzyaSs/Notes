package tech.ermakov.notes.features.notes.ui.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.notes.component.AddFloatingActionButton
import tech.ermakov.notes.features.notes.ui.notes.component.NoteGrid
import tech.ermakov.notes.features.notes.ui.notes.component.NoteList
import tech.ermakov.notes.features.notes.ui.notes.component.SearchTextField
import tech.ermakov.notes.features.notes.ui.notes.component.TopToolbar
import tech.ermakov.notes.features.notes.ui.notes.model.NotesAction
import tech.ermakov.notes.features.notes.ui.notes.model.NotesUiState
import tech.ermakov.notes.features.notes.ui.notes.model.UiNote
import tech.ermakov.notes.features.notes.ui.notes.model.UiNoteListType

@Composable
internal fun NotesScreen() {
    val notesViewModel = koinViewModel<NotesViewModel>()
    val state by notesViewModel.state.collectAsStateWithLifecycle()

    NotesScreenContent(
        state = state,
        onAction = notesViewModel::onAction,
    )
}

@Composable
private fun NotesScreenContent(
    state: NotesUiState,
    onAction: (action: NotesAction) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            AddFloatingActionButton(
                onClick = {
                    onAction(NotesAction.OnAddClick)
                },
            )
        },
        containerColor = NotesTheme.colors.backgroundSecondary,
        modifier = Modifier
            .safeDrawingPadding(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            TopToolbar(
                noteListType = state.noteListType,
                onToolbarClick = { onAction(NotesAction.OnToolbarClick) },
                onNoteListTypeClick = { onAction(NotesAction.OnNoteListTypeClick) },
                onSettingsClick = { onAction(NotesAction.OnSettingsClick) },
                modifier = Modifier
                    .padding(
                        all = 16.dp,
                    ),
            )

            SearchTextField()

            when {
                state.isLoading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator(
                            color = NotesTheme.colors.accent,
                        )
                    }

                }

                state.noteListType == UiNoteListType.LIST -> {
                    NoteList(
                        notes = state.notes,
                        onNoteClick = { noteId ->
                            onAction(NotesAction.OnNoteClick(noteId = noteId))
                        },
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                    )
                }

                state.noteListType == UiNoteListType.CARD -> {
                    NoteGrid(
                        notes = state.notes,
                        onNoteClick = { noteId ->
                            onAction(NotesAction.OnNoteClick(noteId = noteId))
                        },
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NotesScreenContentPreview() {
    NotesTheme {
        NotesScreenContent(
            state = NotesUiState(
                notes = buildList {
                    repeat(2) { add(UiNote.Default) }
                },
                isLoading = false,
            ),
            onAction = { },
        )
    }
}

@Preview
@Composable
private fun LoadingNotesScreenContentPreview() {
    NotesTheme {
        NotesScreenContent(
            state = NotesUiState(
                isLoading = true,
            ),
            onAction = { },
        )
    }
}
