package tech.ermakov.notes.features.notes.ui.noteEditor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.noteEditor.component.BodyTextField
import tech.ermakov.notes.features.notes.ui.noteEditor.component.TitleTextField
import tech.ermakov.notes.features.notes.ui.noteEditor.component.TopToolbar
import tech.ermakov.notes.features.notes.ui.noteEditor.model.EditableNote
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorAction
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorUiState

@Composable
internal fun NoteEditorScreen(
    noteId: Long,
    folderId: Long,
) {
    val noteEditorViewModel = koinViewModel<NoteEditorViewModel>(
        parameters = { parametersOf(noteId, folderId) },
    )
    val state by noteEditorViewModel.state.collectAsStateWithLifecycle()

    NoteEditorScreenContent(
        state = state,
        onAction = noteEditorViewModel::onAction,
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun NoteEditorScreenContent(
    state: NoteEditorUiState,
    onAction: (action: NoteEditorAction) -> Unit,
) {
    Scaffold(
        containerColor = NotesTheme.colors.backgroundPrimary,
        modifier = Modifier
            .safeDrawingPadding(),
    ) { paddingValues ->
        BackHandler {
            onAction(NoteEditorAction.OnBackClick)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .padding(paddingValues = paddingValues),
        ) {
            TopToolbar(
                menuActions = state.getMenuActions(),
                onMenuActionClick = { menuAction ->
                    onAction(NoteEditorAction.OnMenuActionClick(menuAction = menuAction))
                },
                onBackClick = {
                    onAction(NoteEditorAction.OnBackClick)
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 24.dp,
                    ),
            )

            TitleTextField(
                state = state.note.titleTextField,
                isEnabled = state.isEditEnabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp,
                    ),
            )

            BodyTextField(
                state = state.note.bodyTextField,
                isEnabled = state.isEditEnabled,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp,
                    ),
            )
        }
    }
}

@Preview
@Composable
private fun NoteEditorScreenContentPreview() {
    NotesTheme {
        NoteEditorScreenContent(
            state = NoteEditorUiState(
                note = EditableNote.Default.copy(
                    titleTextField = TextFieldState(initialText = "Some title"),
                    bodyTextField = TextFieldState(initialText = "Some body"),
                ),
            ),
            onAction = { },
        )
    }
}
