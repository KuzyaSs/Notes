package tech.ermakov.notes.features.folders.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.add
import notes.composeapp.generated.resources.ic_add
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import tech.ermakov.notes.core.ui.component.fab.NotesFloatingActionButton
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.folders.ui.component.TopToolbar
import tech.ermakov.notes.features.folders.ui.model.FoldersAction
import tech.ermakov.notes.features.folders.ui.model.FoldersUiState

@Composable
internal fun FoldersScreen() {
    val foldersViewModel = koinViewModel<FoldersViewModel>()
    val state by foldersViewModel.state.collectAsStateWithLifecycle()

    FoldersScreenContent(
        state = state,
        onAction = foldersViewModel::onAction,
    )
}

@Composable
private fun FoldersScreenContent(
    state: FoldersUiState,
    onAction: (action: FoldersAction) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            NotesFloatingActionButton(
                drawableRes = Res.drawable.ic_add,
                onClick = {
                    onAction(FoldersAction.OnCreateNewFolderClick)
                },
                contentDescription = stringResource(resource = Res.string.add),
            )
        },
        containerColor = NotesTheme.colors.backgroundSecondary,
        modifier = Modifier
            .safeDrawingPadding(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            TopToolbar(
                onTitleClick = {
                    onAction(FoldersAction.OnToolbarTitleClick)
                },
                modifier = Modifier
                    .padding(
                        all = 16.dp,
                    ),
            )

            // System folders.

            // User folders.
        }
    }
}

@Preview
@Composable
private fun FoldersScreenContentPreview() {
    NotesTheme {
        FoldersScreenContent(
            state = FoldersUiState(),
            onAction = { },
        )
    }
}
