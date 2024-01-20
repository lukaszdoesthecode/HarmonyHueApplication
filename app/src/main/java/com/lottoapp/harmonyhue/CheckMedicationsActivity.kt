package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CheckMedicationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_medications)

        val goBackToMenuFromMedicationsBtn = findViewById<ImageButton>(R.id.goBackToMenuFromMedicationsBtn)

        goBackToMenuFromMedicationsBtn.setOnClickListener{
            val intentGoBackToMenuFromMedicationsBtn = Intent(this, MenuActivity::class.java)
            startActivity(intentGoBackToMenuFromMedicationsBtn)
            finish()
        }
    }
}