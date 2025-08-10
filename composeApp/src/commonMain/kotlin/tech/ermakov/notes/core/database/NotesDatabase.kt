package tech.ermakov.notes.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tech.ermakov.notes.core.database.converter.DateTimeConverter
import tech.ermakov.notes.features.folders.data.local.dao.FolderDao
import tech.ermakov.notes.features.folders.data.local.model.FolderEntity
import tech.ermakov.notes.features.notes.data.local.dao.NoteDao
import tech.ermakov.notes.features.notes.data.local.model.NoteEntity

const val DATABASE_NAME: String = "notes_db"

@Database(
    entities = [
        NoteEntity::class,
        FolderEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(DateTimeConverter::class)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    abstract fun getFolderDao(): FolderDao
}
