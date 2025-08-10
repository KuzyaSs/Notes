package tech.ermakov.notes.features.notes.domain.useCase

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.domain.model.Note

class GetNotesUseCase(
    private val notesRepository: NoteRepository,
) {

    operator fun invoke(folderId: Int? = null, isTrash: Boolean = false): Flow<List<Note>> {
        return when {
            isTrash -> notesRepository.getTrashedNotes()
            folderId != null -> notesRepository.getNotesByFolderId(folderId = folderId)
            else -> notesRepository.getAllNotes()
        }
    }
}
