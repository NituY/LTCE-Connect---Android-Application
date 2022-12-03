package com.example.ltceconnect.NoticeModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "note")
    val note: String?,
    val formatter: String,

    ):java.io.Serializable
