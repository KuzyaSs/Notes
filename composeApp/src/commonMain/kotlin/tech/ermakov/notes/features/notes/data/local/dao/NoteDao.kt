package tech.ermakov.notes.features.notes.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.data.local.model.NoteEntity
import tech.ermakov.notes.features.notes.data.local.model.NoteWithFolderName

@Dao
interface NoteDao {

    @Query(
        """
        SELECT note.*, folder.name as folder_name
        FROM note
        LEFT JOIN folder ON note.folder_id = folder.id
        WHERE note.is_trashed = false
        """,
    )
    fun getAllNotes(): Flow<List<NoteWithFolderName>>

    @Query(
        """
        SELECT note.*, folder.name as folder_name
        FROM note
        LEFT JOIN folder ON note.folder_id = folder.id
        WHERE note.folder_id = :folderId AND note.is_trashed = false
        """,
    )
    fun getNotesByFolderId(folderId: Long): Flow<List<NoteWithFolderName>>

    @Query(
        """
        SELECT note.*, folder.name as folder_name
        FROM note
        LEFT JOIN folder ON note.folder_id = folder.id
        WHERE note.is_trashed = true
        """,
    )
    fun getTrashedNotes(): Flow<List<NoteWithFolderName>>

    @Query(
        """
        SELECT note.*, folder.name as folder_name
        FROM note
        LEFT JOIN folder ON note.folder_id = folder.id
        WHERE note.id = :noteId
        LIMIT 1
        """,
    )
    fun getNoteById(noteId: Long): Flow<NoteWithFolderName?>

    @Upsert
    suspend fun upsertNote(noteEntity: NoteEntity): Long

    @Query(
        """
            DELETE FROM note
            WHERE note.id = :noteId
        """,
    )
    suspend fun deleteNoteById(noteId: Long): Int
}
