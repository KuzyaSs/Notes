package tech.ermakov.notes.features.notes.domain.useCase

import kotlinx.coroutines.flow.firstOrNull
import tech.ermakov.notes.core.utils.currentLocalDateTime
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.domain.model.NEW_NOTE_ID
import tech.ermakov.notes.features.notes.domain.model.NoteContentEdit
import tech.ermakov.notes.features.notes.domain.model.SaveNoteContentResult
import tech.ermakov.notes.features.notes.domain.model.toNote

class SaveNoteContentUseCase(
    private val notesRepository: NoteRepository,
) {

    suspend operator fun invoke(noteContentEdit: NoteContentEdit): SaveNoteContentResult {
        // If a note is empty, so delete it.
        if (noteContentEdit.title.isBlank() && noteContentEdit.body.isBlank()) {
            return if (noteContentEdit.id == NEW_NOTE_ID) {
                SaveNoteContentResult.Nothing
            } else {
                notesRepository.deleteNoteById(noteId = noteContentEdit.id)
                SaveNoteContentResult.Deleted
            }
        }

        val currentNote = notesRepository.getNoteById(noteId = noteContentEdit.id).firstOrNull()
        return if (currentNote == null) {
            // It's a new note, so create it.
            val noteId = notesRepository.upsertNote(note = noteContentEdit.toNote())
            SaveNoteContentResult.Created(noteId = noteId)
        } else {
            // It's an existence note, so update it.
            val isNoteChanged = currentNote.title != noteContentEdit.title ||
                currentNote.body != noteContentEdit.body

            if (isNoteChanged) {
                val updatedNote = currentNote.copy(
                    title = noteContentEdit.title,
                    body = noteContentEdit.body,
                    updateDate = currentLocalDateTime(),
                )
                val noteId = notesRepository.upsertNote(note = updatedNote)
                SaveNoteContentResult.Updated(noteId = noteId)
            } else {
                SaveNoteContentResult.Nothing
            }
        }
    }
}
