package tech.ermakov.notes.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

data class NotesTypography(
    val display: TextStyle,
    val headline: TextStyle,
    val title: TextStyle,
    val body: TextStyle,
)

val LocalTypography = staticCompositionLocalOf<NotesTypography> {
    error("No typography provided")
}

@Composable
fun getNotesTypography(colors: NotesColors): NotesTypography {
    return NotesTypography(
        display = TextStyle(
            color = colors.textPrimary,
            fontSize = 30.sp,
        ),
        headline = TextStyle(
            color = colors.textPrimary,
            fontSize = 22.sp,
        ),
        title = TextStyle(
            color = colors.textPrimary,
            fontSize = 16.sp,
        ),
        body = TextStyle(
            color = colors.textPrimary,
            fontSize = 14.sp,
        ),
    )
}
