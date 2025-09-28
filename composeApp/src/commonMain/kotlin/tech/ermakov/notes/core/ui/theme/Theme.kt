package tech.ermakov.notes.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object NotesTheme {

    val typography: NotesTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val colors: NotesColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val shapes: NotesShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

@Composable
internal fun NotesTheme(
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()

    val colors = getNotesColors(isDarkTheme = systemIsDark)
    val typography = getNotesTypography(colors = colors)
    val shapes = getNotesShapes()

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
    ) {
        SystemAppearance(isDark = !systemIsDark)
        content()
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
