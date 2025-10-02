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
     * Moves a note to the specified folder by the specified id.
     *
     * @param noteId the note id to move.
     * @param folderId the target folder.
     *
     * @return the number of moved notes.
     */
    suspend fun moveNoteById(noteId: Long, folderId: Long): Int

    /**
     * Restores a note from Trash by the specified id.
     *
     * @param noteId the note id to restore.
     *
     * @return the number of restored notes.
     */
    suspend fun restoreNoteById(noteId: Long): Int

    /**
     * Moves a note to Trash by the specified id.
     *
     * @param noteId the note id to trash.
     *
     * @return the number of trashed notes.
     */
    suspend fun deleteNoteById(noteId: Long): Int

    /**
     * Deletes a note by the specified id.
     *
     * @param noteId the note id to delete.
     *
     * @return the number of deleted notes.
     */
    suspend fun deleteNotePermanentlyById(noteId: Long): Int
}
