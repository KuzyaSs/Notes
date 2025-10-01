package tech.ermakov.notes.features.notes.domain.useCase

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.domain.model.Note

class GetNoteByIdUseCase(
    private val notesRepository: NoteRepository,
) {

    operator fun invoke(noteId: Long): Flow<Note?> {
        return notesRepository.getNoteById(noteId = noteId)
    }
}
