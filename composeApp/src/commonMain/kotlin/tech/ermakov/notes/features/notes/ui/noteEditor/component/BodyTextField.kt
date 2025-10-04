package tech.ermakov.notes.features.notes.ui.noteEditor.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.component.textSelectionColors.NotesTextSelectionColors
import tech.ermakov.notes.core.ui.theme.NotesTheme

@Composable
internal fun BodyTextField(
    state: TextFieldState,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(
        LocalTextSelectionColors provides NotesTextSelectionColors,
    ) {
        BasicTextField(
            state = state,
            enabled = isEnabled,
            textStyle = NotesTheme.typography.body,
            cursorBrush = SolidColor(NotesTheme.colors.textPrimary),
            modifier = modifier,
        )
    }
}

@Preview
@Composable
private fun BodyTextFieldPreview() {
    NotesTheme {
        Box(
            modifier = Modifier.background(color = NotesTheme.colors.backgroundPrimary),
        ) {
            BodyTextField(
                state = TextFieldState(initialText = "Some text"),
                isEnabled = true,
            )
        }
    }
}
