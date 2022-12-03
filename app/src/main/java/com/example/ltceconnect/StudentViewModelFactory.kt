package com.example.ltceconnect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ltceconnect.db.StudentDao

class StudentViewModelFactory (
    private val dao : StudentDao

        ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            return StudentViewModel(dao) as T


        }
        throw  IllegalArgumentException("Unknown View Model Class")
    }
}