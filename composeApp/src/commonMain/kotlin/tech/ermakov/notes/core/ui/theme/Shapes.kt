package tech.ermakov.notes.core.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NotesShapes(
    val small: Dp,
    val medium: Dp,
    val large: Dp,
)

val LocalShapes = staticCompositionLocalOf<NotesShapes> {
    error("No shapes provided")
}

fun getNotesShapes(): NotesShapes {
    return NotesShapes(
        small = 8.dp,
        medium = 16.dp,
        large = 24.dp,
    )
}
