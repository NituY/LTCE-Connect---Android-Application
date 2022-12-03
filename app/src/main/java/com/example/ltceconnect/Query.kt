package com.example.ltceconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ltceconnect.databinding.ActivityQueryBinding
import com.example.ltceconnect.db.Student
import com.example.ltceconnect.db.StudentDatabase

class Query : AppCompatActivity() {
   private lateinit var binding: ActivityQueryBinding


//   private lateinit var questEditText: EditText
//   private lateinit var ansEditText: EditText
//   private lateinit var saveButton: Button
//   private lateinit var clearButton: Button

   private lateinit var viewModel: StudentViewModel
//   private lateinit var studentRecyclerView: RecyclerView
   private lateinit var adapter: StudentRecyclerViewAdapter
   private var isListItemClicked = false

   private lateinit var selectedStudent: Student

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      binding = ActivityQueryBinding.inflate(layoutInflater)
      setContentView(binding.root)

       val questEditText = findViewById<EditText>(R.id.etQuery)
       val  ansEditText = findViewById<EditText>(R.id.etAns)
//      val  saveButton = findViewById(R.id.btnSave)
//     val  clearButton = findViewById(R.id.btnClear)
//      val  studentRecyclerView = findViewById(R.id.rvStudent )

      val dao = StudentDatabase.getInstance(application).studentDao()
      val factory = StudentViewModelFactory(dao)
      viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)

      binding.apply {
         btnSave.setOnClickListener {
           val  questEdit =  questEditText.text.toString().trim()
            if (questEdit.isEmpty()){
               questEditText.error = "Invalid Input"
               return@setOnClickListener
            }

             else if (isListItemClicked ) {
               updateStudentData()
               clearInput()
            } else {
               saveStudentData()
               clearInput()
            }
            initRecyclerView()
         }

       btnClear.setOnClickListener {
            if (isListItemClicked) {
               deleteStudentData()
               clearInput()
            } else {
               clearInput()
            }

         }

      }
   }


   private fun saveStudentData() {

      binding.apply {
         viewModel.insertStudent(
            Student(
               0,
               etQuery.text.toString(),
               etAns.text.toString()
            )
         )
      }
   }


   private fun updateStudentData() {
      binding.apply {
         viewModel.updateStudent(
            Student(
               selectedStudent.id,
               etQuery.text.toString(),
               etAns.text.toString()
            )
         )
         btnSave.text = "Save"
         btnClear.text = "Clear"
         isListItemClicked = false
      }
   }

   private fun deleteStudentData() {
      binding.apply {
         viewModel.deleteStudent(
            Student(
               selectedStudent.id,
               etQuery.text.toString(),
               etAns.text.toString()
            )
         )
         btnSave.text = "Save"
         btnClear.text = "Clear"
         isListItemClicked = false
      }
   }

   private fun clearInput() {
      binding.apply {
         etQuery.setText("")
         etAns.setText("")
      }
   }

   private fun initRecyclerView() {


         binding.rvStudent.layoutManager = LinearLayoutManager(this)
         adapter = StudentRecyclerViewAdapter { selectedItem: Student ->
            listItemClicked(selectedItem)
         }

        binding.rvStudent.adapter = adapter

         displayStudentsList()

   }

   private fun displayStudentsList() {
      viewModel.students.observe(this, {
         adapter.setList(it)
         adapter.notifyDataSetChanged()

      })
   }

   private fun listItemClicked(student: Student) {
      binding.apply {
         selectedStudent = student
            btnSave.text = "Update"
         btnClear.text = "Delete"
         isListItemClicked = true
         etQuery.setText(selectedStudent.question)
         etAns.setText(selectedStudent.answer)
      }
   }
}
