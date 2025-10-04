package tech.ermakov.notes.core.ui.component.fab

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.add
import notes.composeapp.generated.resources.ic_add
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.theme.NotesTheme

@Composable
internal fun NotesFloatingActionButton(
    drawableRes: DrawableResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = NotesTheme.colors.backgroundPrimary,
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(resource = drawableRes),
            contentDescription = contentDescription,
            tint = NotesTheme.colors.accent,
        )
    }
}

@Preview
@Composable
private fun FloatingActionButtonPreview() {
    NotesTheme {
        NotesFloatingActionButton(
            drawableRes = Res.drawable.ic_add,
            onClick = { },
            contentDescription = stringResource(resource = Res.string.add),
        )
    }
}
