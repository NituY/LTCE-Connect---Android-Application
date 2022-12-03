package com.example.ltceconnect.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_data_table")
data class Student(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    var id: Int,

    @ColumnInfo(name = "student_Question")
    var question: String,

    @ColumnInfo(name = "student_Ans")
    var answer: String

)