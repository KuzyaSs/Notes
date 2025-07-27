package tech.ermakov.notes.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object NotesTheme {

    val colors: NotesColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

@Composable
internal fun NotesTheme(
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    CompositionLocalProvider(
        LocalColors provides getNotesColors(isDarkTheme = systemIsDark),
    ) {
        SystemAppearance(isDark = !systemIsDark)
        content()
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
