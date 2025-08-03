package tech.ermakov.notes.features.folders.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folder")
data class FolderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
)
