package tech.ermakov.notes.features.notes.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.model.NavigatorAction
import tech.ermakov.notes.core.ui.viewModel.BaseViewModel
import tech.ermakov.notes.features.folders.ui.FoldersDestination
import tech.ermakov.notes.features.noteEditor.ui.NoteEditorDestination
import tech.ermakov.notes.features.notes.domain.useCase.GetNotesUseCase
import tech.ermakov.notes.features.notes.ui.model.NotesAction
import tech.ermakov.notes.features.notes.ui.model.NotesUiState
import tech.ermakov.notes.features.settings.ui.SettingsDestination

internal class NotesViewModel(
    private val getNotesUseCase: GetNotesUseCase,
    private val navigator: Navigator,
) : BaseViewModel<NotesUiState, NotesAction>() {

    private val _state: MutableStateFlow<NotesUiState> = MutableStateFlow(NotesUiState())

    override val state: StateFlow<NotesUiState>
        get() = _state.asStateFlow()

    override fun onAction(action: NotesAction) {
        when (action) {
            NotesAction.OnToolbarClick -> navigateToFoldersScreen()
            NotesAction.OnNoteListTypeClick -> changeNoteListType()
            NotesAction.OnSettingsClick -> navigateToSettingsScreen()
            NotesAction.OnAddClick -> navigateToEditorScreen()
        }
    }

    private fun navigateToFoldersScreen() {
        navigator.onAction(
            action = NavigatorAction.Navigate(destination = FoldersDestination),
        )
    }

    private fun changeNoteListType() {
        // TODO
    }

    private fun navigateToSettingsScreen() {
        navigator.onAction(
            action = NavigatorAction.Navigate(destination = SettingsDestination),
        )
    }

    private fun navigateToEditorScreen() {
        navigator.onAction(
            action = NavigatorAction.Navigate(destination = NoteEditorDestination),
        )
    }
}
