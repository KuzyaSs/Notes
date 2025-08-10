package tech.ermakov.notes.features.folders.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.folders.data.local.model.FolderEntity
import tech.ermakov.notes.features.folders.data.local.model.FolderWithNotesCount

@Dao
interface FolderDao {

    @Query(
        """
        SELECT folder.*, COUNT(*) as notes_count
        FROM folder
        LEFT JOIN note ON folder.id = note.folder_id
        GROUP BY folder.id
        """,
    )
    fun getAllFolders(): Flow<List<FolderWithNotesCount>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFolder(folderEntity: FolderEntity): Long
}
