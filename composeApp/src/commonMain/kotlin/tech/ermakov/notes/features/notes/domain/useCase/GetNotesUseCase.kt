package tech.ermakov.notes.features.notes.domain.useCase

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.folders.domain.model.ALL_NOTES_FOLDER_ID
import tech.ermakov.notes.features.folders.domain.model.TRASH_FOLDER_ID
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.domain.model.Note

class GetNotesUseCase(
    private val notesRepository: NoteRepository,
) {

    operator fun invoke(folderId: Long): Flow<List<Note>> {
        return when (folderId) {
            ALL_NOTES_FOLDER_ID -> notesRepository.getAllNotes()
            TRASH_FOLDER_ID -> notesRepository.getTrashedNotes()
            else -> notesRepository.getNotesByFolderId(folderId = folderId)
        }
    }
}
