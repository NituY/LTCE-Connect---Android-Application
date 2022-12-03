package com.example.ltceconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Database

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var helper =MyDbHelper(applicationContext)
        var db =helper.readableDatabase
        var subButton = findViewById<Button>(R.id.btnSig)
        var usernameText = findViewById<EditText>(R.id.usenSname)
        var passwordText = findViewById<EditText>(R.id.Spassword)
        subButton.setOnClickListener{

            val username = usernameText.text.toString().trim()
            val password = passwordText.text.toString().trim()
            if (username.isEmpty()){
                usernameText.error = "Username Required "
                return@setOnClickListener
            } else if (password.isEmpty()){
                passwordText.error =" Password Required"
                return@setOnClickListener
            } else{
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

            }
            var args = listOf<String>(usernameText.text.toString(),passwordText.text.toString()).toTypedArray()
            var rs = db.rawQuery("SELECT * FROM LOGIN WHERE USER_NAME=? AND PASSWORD = ?",args)
           if (rs.moveToNext() ) {

               Toast.makeText(applicationContext, "Welcome to Access", Toast.LENGTH_LONG).show()
           }

            else {
               Toast.makeText(applicationContext, "Invalid", Toast.LENGTH_LONG).show()
               return@setOnClickListener
           }


        }
    }
}