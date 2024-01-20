package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class TherapyTypesActivity : AppCompatActivity() {

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_therapy_types)

        val goToMenuFromTherapyBtn = findViewById<ImageButton>(R.id.goToMenuFromTherapyBtn)
        val cbtBtn = findViewById<Button>(R.id.cbtBtn)
        val pdtBtn = findViewById<Button>(R.id.pdtBtn)
        val htBtn = findViewById<Button>(R.id.htBtn)
        val gtBtn = findViewById<Button>(R.id.gtBtn)

        goToMenuFromTherapyBtn.setOnClickListener{
            val intentGoToMenuFromTherapyBtn = Intent(this, MenuActivity::class.java)
            startActivity(intentGoToMenuFromTherapyBtn)
            finish()
        }

        cbtBtn.setOnClickListener {
            showMessage("Cognitive behavioral therapy info")
        }

        pdtBtn.setOnClickListener {
            showMessage("Psychodynamic therapy info")
        }

        htBtn.setOnClickListener {
            showMessage("Humanistic Therapy")
        }

        gtBtn.setOnClickListener {
            showMessage("Gestalt Therapy")
        }
    }
}