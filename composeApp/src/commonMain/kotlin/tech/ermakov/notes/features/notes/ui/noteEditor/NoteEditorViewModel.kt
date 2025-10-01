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
import tech.ermakov.notes.features.notes.domain.useCase.GetNoteByIdUseCase
import tech.ermakov.notes.features.notes.domain.useCase.SaveNoteContentUseCase
import tech.ermakov.notes.features.notes.ui.noteEditor.model.EditableNote
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorAction
import tech.ermakov.notes.features.notes.ui.noteEditor.model.NoteEditorUiState
import tech.ermakov.notes.features.notes.ui.noteEditor.model.toEditableNote
import tech.ermakov.notes.features.notes.ui.noteEditor.model.toNoteContentEdit

internal class NoteEditorViewModel(
    noteId: Long,
    folderId: Long,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val saveNoteContentUseCase: SaveNoteContentUseCase,
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
        println("init: noteId: $noteId | folderId: $folderId")
        setNoteById(noteId = noteId)
    }

    override fun onAction(action: NoteEditorAction) {
        when (action) {
            NoteEditorAction.OnBackClick -> backToPreviousScreen()
        }
    }

    private fun setNoteById(noteId: Long): Job = viewModelScope.launch {
        val note = getNoteByIdUseCase(noteId = noteId).firstOrNull()
        _state.update { state ->
            println("setNoteById is null: ${note == null}")
            state.copy(
                note = note?.toEditableNote() ?: state.note,
                isLoading = false,
            )
        }
    }

    private fun backToPreviousScreen() {
        saveNoteContent().invokeOnCompletion {
            navigator.onAction(action = NavigatorAction.Back())
        }
    }

    private fun saveNoteContent(): Job = viewModelScope.launch {
        if (!state.value.isSaving) {
            _state.update { state ->
                state.copy(
                    isSaving = true,
                )
            }
            val noteToSave = state.value.note.toNoteContentEdit()
            saveNoteContentUseCase(noteContentEdit = noteToSave).also {
                println("saveNoteContentUseCase result: $it | noteToSave: $noteToSave")
            }
        }
    }
}
