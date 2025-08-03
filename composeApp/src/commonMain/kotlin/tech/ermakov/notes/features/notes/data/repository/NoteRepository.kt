package tech.ermakov.notes.features.notes.data.repository

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.domain.Note

interface NoteRepository {

    fun getAllNotes(): Flow<List<Note>>

    fun getNotesByFolderId(folderId: Int): Flow<List<Note>>

    fun getTrashedNotes(): Flow<List<Note>>
}
