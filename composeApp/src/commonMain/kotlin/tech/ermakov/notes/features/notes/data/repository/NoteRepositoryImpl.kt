package tech.ermakov.notes.features.notes.data.repository

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.data.local.dao.NoteDao
import tech.ermakov.notes.features.notes.domain.Note

internal class NoteRepositoryImpl(
    private val noteDao: NoteDao,
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getNotesByFolderId(folderId: Int): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun getTrashedNotes(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }
}
