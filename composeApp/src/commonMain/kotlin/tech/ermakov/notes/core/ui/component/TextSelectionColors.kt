package tech.ermakov.notes.core.ui.component

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import tech.ermakov.notes.core.ui.theme.NotesTheme

val NotesTextSelectionColors: TextSelectionColors
    @Composable
    get() = TextSelectionColors(
        handleColor = NotesTheme.colors.accent,
        backgroundColor = NotesTheme.colors.accent.copy(alpha = 0.4f),
    )
