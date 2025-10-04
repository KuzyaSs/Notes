package tech.ermakov.notes.features.notes.ui.notes

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.model.NavigatorAction
import tech.ermakov.notes.core.ui.viewModel.BaseViewModel
import tech.ermakov.notes.features.folders.domain.model.ALL_NOTES_FOLDER_ID
import tech.ermakov.notes.features.folders.domain.model.TRASH_FOLDER_ID
import tech.ermakov.notes.features.folders.ui.FoldersDestination
import tech.ermakov.notes.features.notes.domain.model.NEW_NOTE_ID
import tech.ermakov.notes.features.notes.ui.noteEditor.NoteEditorDestination
import tech.ermakov.notes.features.notes.domain.model.Note
import tech.ermakov.notes.features.notes.domain.useCase.GetNotesUseCase
import tech.ermakov.notes.features.notes.ui.notes.model.NotesAction
import tech.ermakov.notes.features.notes.ui.notes.model.NotesUiState
import tech.ermakov.notes.features.notes.ui.notes.model.toUiNote
import tech.ermakov.notes.features.settings.ui.SettingsDestination

internal class NotesViewModel(
    private val getNotesUseCase: GetNotesUseCase,
    private val navigator: Navigator,
) : BaseViewModel<NotesUiState, NotesAction>() {

    private val _state: MutableStateFlow<NotesUiState> = MutableStateFlow(NotesUiState())

    override val state: StateFlow<NotesUiState>
        get() = _state.asStateFlow()

    private var selectedFolderId: Long = ALL_NOTES_FOLDER_ID

    init {
        observeNotes(folderId = selectedFolderId)
    }

    override fun onAction(action: NotesAction) {
        when (action) {
            NotesAction.OnToolbarTitleClick -> navigateToFoldersScreen()
            NotesAction.OnNoteListTypeClick -> changeNoteListType()
            NotesAction.OnSettingsClick -> navigateToSettingsScreen()
            is NotesAction.OnNoteClick -> navigateToEditorScreen(
                noteId = action.noteId,
            )

            NotesAction.OnCreateNewNoteClick -> navigateToEditorScreen(
                noteId = NEW_NOTE_ID,
            )
        }
    }

    private fun observeNotes(folderId: Long) {
        viewModelScope.launch {
            getNotesUseCase.invoke(folderId = folderId).collect { notes ->
                _state.update { state ->
                    state.copy(
                        notes = notes.map(Note::toUiNote),
                        isLoading = false,
                    )
                }
            }
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

    private fun navigateToEditorScreen(noteId: Long, folderId: Long = selectedFolderId) {
        navigator.onAction(
            action = NavigatorAction.Navigate(
                destination = NoteEditorDestination(
                    noteId = noteId,
                    folderId = if (noteId == NEW_NOTE_ID && folderId == TRASH_FOLDER_ID) {
                        ALL_NOTES_FOLDER_ID
                    } else {
                        folderId
                    },
                )
            ),
        )
    }
}
