package tech.ermakov.notes.features.folders.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tech.ermakov.notes.features.folders.data.local.dao.FolderDao
import tech.ermakov.notes.features.folders.data.local.model.FolderEntity
import tech.ermakov.notes.features.folders.data.local.model.FolderWithNotesCount
import tech.ermakov.notes.features.folders.data.local.model.toFolder
import tech.ermakov.notes.features.folders.domain.model.Folder

internal class FolderRepositoryImpl(
    private val folderDao: FolderDao,
) : FolderRepository {

    override fun getAllFolders(): Flow<List<Folder>> {
        return folderDao.getAllFolders().map { folders ->
            folders.map(FolderWithNotesCount::toFolder)
        }
    }

    override suspend fun insertFolder(folderName: String): Long {
        return folderDao.insertFolder(
            folderEntity = FolderEntity(name = folderName),
        )
    }
}
