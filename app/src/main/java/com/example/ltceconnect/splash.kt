package com.example.ltceconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val iv_note = findViewById<ImageView>(R.id.iv_image)
        iv_note.alpha =0f
        iv_note.animate().setDuration(1500).alpha(1f).withEndAction{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}