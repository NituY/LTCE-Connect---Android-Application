package com.example.ltceconnect


//class hStudentRecyclerViewAdapter(
//    private val clickListener: (hStudent)->Unit
//): RecyclerView.Adapter<StudentViewHolder>(){
//
//    private  val studentList = ArrayList<Student>()
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
////        val layoutInflater = LayoutInflater.from(parent.context)
////        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
//        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return StudentViewHolder(binding )
//    }
//
//    override fun onBindViewHolder(holder: hStudentViewHolder, position: Int) {
//        holder.bind(studentList[position],clickListener)
//    }
//
//    override fun getItemCount(): Int {
//        return studentList.size
//    }
//
//    fun setList(students:List<Student>){
//        studentList.clear()
//        studentList.addAll(students)
//    }
//
//}
//class hStudentViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
//    fun bind(student: hStudent, clickListener: (hStudent) -> Unit) {
//        binding.apply {
////            val queTextView = view.findViewById<TextView>(R.id.tvQues)
////            val ansTextView = view.findViewById<TextView>(R.id.tvAnd)
//
////            names.text = student.date
////            tvAnd.text = student.answer
////            root.setOnClickListener {
////                clickListener(student)
////
////            }
//
//        }
//    }
//}