package tech.ermakov.notes.features.notes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.data.local.model.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note WHERE folder_id = :folderId")
    fun getNotesByFolderId(folderId: Int): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note WHERE is_trashed = true")
    fun getTrashedNotes(): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity)
}
