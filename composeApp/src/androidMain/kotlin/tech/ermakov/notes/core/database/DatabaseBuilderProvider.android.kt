package tech.ermakov.notes.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual interface DatabaseBuilderProvider {
    actual fun provide(): RoomDatabase.Builder<NotesDatabase>
}

internal class DatabaseBuilderProviderImpl(
    private val context: Context,
) : DatabaseBuilderProvider {

    override fun provide(): RoomDatabase.Builder<NotesDatabase> {
        val applicationContext = context.applicationContext
        val databaseFilePath = applicationContext.getDatabasePath(DATABASE_NAME).absolutePath
        return Room.databaseBuilder<NotesDatabase>(
            context = context,
            name = databaseFilePath,
        )
    }
}
