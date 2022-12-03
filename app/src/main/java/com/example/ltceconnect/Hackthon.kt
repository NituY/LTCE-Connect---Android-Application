package com.example.ltceconnect

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ltceconnect.model.linkData
import com.example.ltceconnect.view.UserAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Date

class Hackthon : AppCompatActivity() {
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv :RecyclerView
    private lateinit var userList: ArrayList<linkData>
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hackthon)

        userList = ArrayList()

        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.myRecyle)
        userAdapter = UserAdapter(this,userList)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter

        addsBtn.setOnClickListener{addInfo()}




    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.add_item,null)
        val userName = v.findViewById<EditText>(R.id.userName)
        val userNo = v.findViewById<EditText>(R.id.userNo)

        val addDialog = AlertDialog.Builder(this)


        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
            dialog,_ ->
            val names = userName.text.toString()
            val number =userNo.text.toString()
            userList.add(linkData("Date: $names", "Link: $number"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Adding Hackthons Information Success",Toast.LENGTH_SHORT).show()
            dialog.dismiss()

        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_ ->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()
    }



}


