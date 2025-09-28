package tech.ermakov.notes.features.notes.ui.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.add
import notes.composeapp.generated.resources.ic_add
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.ui.theme.NotesTheme

@Composable
internal fun AddFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = NotesTheme.colors.backgroundPrimary,
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(resource = Res.drawable.ic_add),
            contentDescription = stringResource(resource = Res.string.add),
            tint = NotesTheme.colors.accent,
        )
    }
}

@Preview
@Composable
private fun AddFloatingActionButtonPreview() {
    NotesTheme {
        AddFloatingActionButton(
            onClick = { },
        )
    }
}
