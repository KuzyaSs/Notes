package tech.ermakov.notes.features.folders.data.repository

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.folders.domain.model.Folder

interface FolderRepository {

    fun getAllFolders(): Flow<List<Folder>>

    suspend fun insertFolder(folderName: String): Long
}
