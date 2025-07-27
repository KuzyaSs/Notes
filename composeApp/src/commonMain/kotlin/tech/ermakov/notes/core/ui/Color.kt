package tech.ermakov.notes.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class NotesColors(
    val textPrimary: Color,
    val textSecondary: Color,
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val accent: Color,
    val transparent: Color,
)

val LocalColors = staticCompositionLocalOf<NotesColors> {
    error("No color provided")
}

@Composable
fun getNotesColors(isDarkTheme: Boolean): NotesColors {
    return if (isDarkTheme) {
        NotesColors(
            textPrimary = Color(0xFFFFFFFF),
            textSecondary = Color(0xFF9E9E9E),
            backgroundPrimary = Color(0xFF1A1A1A),
            backgroundSecondary = Color(0x00000000),
            accent = Color(0xFF0B99FF),
            transparent = Color(0x00000000),
        )
    } else {
        NotesColors(
            textPrimary = Color(0xFF000000),
            textSecondary = Color(0xFF9E9E9E),
            backgroundPrimary = Color(0xFFFFFFFF),
            backgroundSecondary = Color(0xFFF7F7F7),
            accent = Color(0xFF0B99FF),
            transparent = Color(0x00000000),
        )
    }
}
