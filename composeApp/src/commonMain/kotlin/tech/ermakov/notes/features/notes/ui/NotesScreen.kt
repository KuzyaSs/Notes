package tech.ermakov.notes.features.notes.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import tech.ermakov.notes.core.ui.NotesTheme
import tech.ermakov.notes.features.notes.ui.component.AddFloatingActionButton
import tech.ermakov.notes.features.notes.ui.component.SearchTextField
import tech.ermakov.notes.features.notes.ui.component.TopToolBar
import tech.ermakov.notes.features.notes.ui.model.NoteListType
import tech.ermakov.notes.features.notes.ui.model.NotesAction
import tech.ermakov.notes.features.notes.ui.model.NotesUiState

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
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            TopToolBar()

            SearchTextField()

            when {
                state.isLoading -> {

                }

                state.noteListType == NoteListType.LIST -> {

                }

                state.noteListType == NoteListType.CARD -> {

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
            state = NotesUiState(),
            onAction = { },
        )
    }
}
