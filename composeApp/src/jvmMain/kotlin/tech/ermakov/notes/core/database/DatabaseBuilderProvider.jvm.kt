package tech.ermakov.notes.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual interface DatabaseBuilderProvider {
    actual fun provide(): RoomDatabase.Builder<NotesDatabase>
}

internal class DatabaseBuilderProviderImpl : DatabaseBuilderProvider {

    override fun provide(): RoomDatabase.Builder<NotesDatabase> {
        val databaseFilePath = File(
            System.getProperty("java.io.tmpdir"),
            DATABASE_NAME,
        ).absolutePath
        return Room.databaseBuilder<NotesDatabase>(
            name = databaseFilePath,
        )
    }
}
