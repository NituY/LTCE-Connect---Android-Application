package com.example.ltceconnect

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.ltceconnect.databinding.ListItemBinding
import com.example.ltceconnect.db.Student
import com.example.ltceconnect.db.StudentDao
import java.lang.IllegalArgumentException

class StudentRecyclerViewAdapter(
   private val clickListener: (Student)->Unit
):RecyclerView.Adapter<StudentViewHolder>(){

    private  val studentList = ArrayList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
            val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StudentViewHolder(binding )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position],clickListener)
    }

    override fun getItemCount(): Int {
      return studentList.size
    }

    fun setList(students:List<Student>){
        studentList.clear()
        studentList.addAll(students)
    }

}
class StudentViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(student:Student, clickListener: (Student)->Unit ) {
        binding.apply {
//            val queTextView = view.findViewById<TextView>(R.id.tvQues)
//            val ansTextView = view.findViewById<TextView>(R.id.tvAnd)

            tvQues.text = student.question
            tvAnd.text = student.answer
            root.setOnClickListener {
                clickListener(student)

            }

        }
    }
}