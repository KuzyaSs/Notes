package tech.ermakov.notes.features.notes.ui.noteEditor

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.model.NavigatorAction
import tech.ermakov.notes.core.ui.viewModel.BaseViewModel
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.domain.useCase.GetNoteByIdUseCase
import tech.ermakov.notes.features.notes.domain.useCase.MoveNoteByIdUseCase
import tech.ermakov.notes.features.notes.domain.useCase.SaveNoteContentUseCase
import tech.ermakov.notes.features.notes.ui.noteEditor.model.EditableNote
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorAction
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorMenuAction
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorUiState
import tech.ermakov.notes.features.notes.ui.noteEditor.model.toEditableNote
import tech.ermakov.notes.features.notes.ui.noteEditor.model.toNoteContentEdit

internal class NoteEditorViewModel(
    noteId: Long,
    folderId: Long,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val saveNoteContentUseCase: SaveNoteContentUseCase,
    private val moveNoteByIdUseCase: MoveNoteByIdUseCase,
    private val noteRepository: NoteRepository,
    private val navigator: Navigator,
) : BaseViewModel<NoteEditorUiState, NoteEditorAction>() {

    private val _state: MutableStateFlow<NoteEditorUiState> = MutableStateFlow(
        NoteEditorUiState(
            note = EditableNote.Default.copy(
                id = noteId,
                folderId = folderId,
            )
        )
    )

    override val state: StateFlow<NoteEditorUiState>
        get() = _state.asStateFlow()

    init {
        setNoteById(noteId = noteId)
    }

    override fun onAction(action: NoteEditorAction) {
        when (action) {
            NoteEditorAction.OnBackClick -> backToPreviousScreen(
                action = { saveNoteContent() },
            )

            is NoteEditorAction.OnMenuActionClick -> handleMenuAction(
                menuAction = action.menuAction,
            )
        }
    }

    private fun setNoteById(noteId: Long): Job = viewModelScope.launch {
        val note = getNoteByIdUseCase(noteId = noteId).firstOrNull()
        _state.update { state ->
            state.copy(
                note = note?.toEditableNote() ?: state.note,
                isLoading = false,
            )
        }
    }

    /**
     * Backs to the previous screen when the [action] is completed.
     *
     * @param action the action that will be invoked before backing.
     */
    private fun backToPreviousScreen(action: suspend () -> Unit) {
        if (!state.value.isBacking) {
            _state.update { state ->
                state.copy(
                    isBacking = true,
                )
            }

            viewModelScope.launch {
                action()
                navigator.onAction(action = NavigatorAction.Back())
            }
        }
    }

    private fun handleMenuAction(menuAction: NoteEditorMenuAction) {
        when (menuAction) {
            NoteEditorMenuAction.MOVE -> {
                // TODO
            }

            NoteEditorMenuAction.DELETE -> {
                deleteNote()
            }

            NoteEditorMenuAction.DELETE_PERMANENTLY -> {
                deleteNotePermanently()
            }

            NoteEditorMenuAction.RESTORE -> {
                viewModelScope.launch {
                    restoreNote()
                }
            }
        }
    }

    private suspend fun saveNoteContent() {
        val noteToSave = state.value.note.toNoteContentEdit()
        saveNoteContentUseCase(noteContentEdit = noteToSave)
    }

    private suspend fun moveNote(folderId: Long) {
        val note = state.value.note
        moveNoteByIdUseCase(noteId = note.id, folderId = folderId).onSuccess {
            setNoteById(noteId = note.id)
        }
    }

    private suspend fun restoreNote() {
        val note = state.value.note
        noteRepository.restoreNoteById(noteId = note.id)
        setNoteById(noteId = note.id)
    }

    private fun deleteNote() {
        backToPreviousScreen(
            action = { noteRepository.deleteNoteById(noteId = state.value.note.id) },
        )
    }

    private fun deleteNotePermanently() {
        backToPreviousScreen(
            action = { noteRepository.deleteNotePermanentlyById(noteId = state.value.note.id) },
        )
    }
}
