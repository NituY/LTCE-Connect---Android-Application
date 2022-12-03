package com.example.ltceconnect.NoticeDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.ltceconnect.Converter
import com.example.ltceconnect.NoticeModel.Note
import com.example.ltceconnect.NoticeUtilities.DATABASE_NAME


@Database(entities = arrayOf(Note::class) , version = 1, exportSchema = false)
@TypeConverters( Converter::class)
abstract class noteDatabase:RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object{
        @Volatile
        private var INSTANCE :noteDatabase?=null
        fun getnoteDatabase(context: Context):noteDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    noteDatabase::class.java,
                    DATABASE_NAME

                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}