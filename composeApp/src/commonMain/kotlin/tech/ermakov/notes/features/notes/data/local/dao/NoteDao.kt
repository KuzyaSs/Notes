package tech.ermakov.notes.features.notes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
    fun getNotesByFolderId(folderId: Int): Flow<List<NoteWithFolderName>>

    @Query(
        """
        SELECT note.*, folder.name as folder_name
        FROM note
        LEFT JOIN folder ON note.folder_id = folder.id
        WHERE note.is_trashed = true
        """,
    )
    fun getTrashedNotes(): Flow<List<NoteWithFolderName>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity): Long
}
