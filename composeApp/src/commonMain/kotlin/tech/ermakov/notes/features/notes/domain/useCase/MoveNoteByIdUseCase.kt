package tech.ermakov.notes.features.notes.domain.useCase

import tech.ermakov.notes.features.folders.domain.model.TRASH_FOLDER_ID
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.domain.model.MoveToTrashException

class MoveNoteByIdUseCase(
    private val notesRepository: NoteRepository,
) {

    suspend operator fun invoke(noteId: Long, folderId: Long): Result<Int> {
        return if (folderId != TRASH_FOLDER_ID) {
            Result.success(notesRepository.moveNoteById(noteId = noteId, folderId = folderId))
        } else {
            Result.failure(MoveToTrashException())
        }
    }
}
