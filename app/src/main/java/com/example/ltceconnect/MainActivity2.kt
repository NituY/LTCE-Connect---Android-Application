package com.example.ltceconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val querButton = findViewById<Button>(R.id.btnQuer)
        querButton.setOnClickListener {
            val intent = Intent(this, Query::class.java)
            startActivity(intent)
        }
        val hackButton = findViewById<Button>(R.id.btnHack)
        hackButton.setOnClickListener {
            val intent = Intent(this, Hackthon::class.java)
            startActivity(intent)
        }
        val alumniButton = findViewById<Button>(R.id.btnAlumn)
        alumniButton.setOnClickListener {
            val intent = Intent(this, Alumni::class.java)
            startActivity(intent)
        }
        val eNoticeButton = findViewById<Button>(R.id.btnEnot)
        eNoticeButton.setOnClickListener {
            val intent = Intent(this, E_Notice::class.java)
            startActivity(intent)
        }
    }
}