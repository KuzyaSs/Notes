package tech.ermakov.notes.features.notes.data.repository

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.domain.model.Note

interface NoteRepository {

    fun getAllNotes(): Flow<List<Note>>

    fun getNotesByFolderId(folderId: Long): Flow<List<Note>>

    fun getTrashedNotes(): Flow<List<Note>>

    fun getNoteById(noteId: Long): Flow<Note?>

    suspend fun upsertNote(note: Note): Long

    /**
     * Deletes a note by the specified id.
     *
     * @param noteId the note id to delete.
     *
     * @return the number of deleted notes.
     */
    suspend fun deleteNoteById(noteId: Long): Int
}
