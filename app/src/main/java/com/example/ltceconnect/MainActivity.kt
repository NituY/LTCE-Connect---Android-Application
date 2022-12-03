package com.example.ltceconnect

import android.app.DownloadManager
import android.app.ProgressDialog.show
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.viewmodel.CreationExtras

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = MyDbHelper(applicationContext)
        var db = helper.readableDatabase
//        var rs = db.rawQuery("SELECT * FROM LOGIN", null)
//
//        if (rs.moveToNext())
//            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()
//

        var regButton = findViewById<Button>(R.id.regbtn)
        var usernameText = findViewById<EditText>(R.id.username)
        var passwordText = findViewById<EditText>(R.id.password)
        var signButton= findViewById<Button>(R.id.signbtn)

        regButton.setOnClickListener {
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


            var cv = ContentValues()

            cv.put("USER_NAME", usernameText.text.toString())
            cv.put("Password", passwordText.text.toString())
            db.insert("LOGIN", null, cv)

            usernameText.setText("")
            passwordText.setText("")

        }
        signButton.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)

        }






    }



}