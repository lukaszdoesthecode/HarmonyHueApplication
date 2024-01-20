package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class DisplayTherapist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_therapist)

        val goToMenuFromTherapistBtn = findViewById<ImageButton>(R.id.goToMenuFromTherapistBtn)
        goToMenuFromTherapistBtn.setOnClickListener{
            val intentGoToMenuFromTherapistBtn = Intent(this, MenuActivity::class.java)
            startActivity(intentGoToMenuFromTherapistBtn)
            finish()
        }
    }
}