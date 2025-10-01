package tech.ermakov.notes.features.notes.ui.noteEditor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.notes.ui.noteEditor.components.TopToolbar
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

@Composable
private fun NoteEditorScreenContent(
    state: NoteEditorUiState,
    onAction: (action: NoteEditorAction) -> Unit,
) {
    Scaffold(
        containerColor = NotesTheme.colors.backgroundPrimary,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
        ) {
            TopToolbar(
                onBackClick = {
                    onAction(NoteEditorAction.OnBackClick)
                },
                modifier = Modifier
                    .padding(
                        all = 16.dp,
                    ),
            )

            CompositionLocalProvider(
                LocalTextSelectionColors provides TextSelectionColors(
                    handleColor = NotesTheme.colors.accent,
                    backgroundColor = NotesTheme.colors.accent.copy(alpha = 0.4f),
                )
            ) {
                // Title.
                BasicTextField(
                    state = state.note.titleTextField,
                    textStyle = NotesTheme.typography.display.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                    lineLimits = TextFieldLineLimits.SingleLine,
                    cursorBrush = SolidColor(NotesTheme.colors.textPrimary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                )

                // Content.
                BasicTextField(
                    state = state.note.bodyTextField,
                    textStyle = NotesTheme.typography.body,
                    cursorBrush = SolidColor(NotesTheme.colors.textPrimary),
                    modifier = Modifier
                        .fillMaxSize(),
                )
            }
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
