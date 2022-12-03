package com.example.ltceconnect.NoticeDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ltceconnect.NoticeModel.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)
//    @Update
//    suspend fun update(note: Int?, title: String?, note1: String?)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM note_table order by id ASC")
    fun getAllNotes():LiveData<List<Note>>
//
}