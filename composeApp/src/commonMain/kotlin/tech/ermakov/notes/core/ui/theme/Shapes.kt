package tech.ermakov.notes.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class NotesShapes(
    val small: Shape,
    val medium: Shape,
    val large: Shape,
)

val LocalShapes = staticCompositionLocalOf<NotesShapes> {
    error("No shapes provided")
}

fun getNotesShapes(): NotesShapes {
    return NotesShapes(
        small = RoundedCornerShape(size = 8.dp),
        medium = RoundedCornerShape(size = 16.dp),
        large = RoundedCornerShape(size = 24.dp),
    )
}
