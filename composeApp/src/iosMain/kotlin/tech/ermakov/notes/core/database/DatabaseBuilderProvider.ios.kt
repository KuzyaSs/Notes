package tech.ermakov.notes.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

actual interface DatabaseBuilderProvider {

    actual fun provide(): RoomDatabase.Builder<NotesDatabase>
}

internal class DatabaseBuilderProviderImpl : DatabaseBuilderProvider {

    override fun provide(): RoomDatabase.Builder<NotesDatabase> {
        val databaseFilePath = NSHomeDirectory() + "/$DATABASE_NAME"
        return Room.databaseBuilder<NotesDatabase>(
            name = databaseFilePath,
            factory = { NotesDatabase::class.instantiateImpl() },
        )
    }
}
