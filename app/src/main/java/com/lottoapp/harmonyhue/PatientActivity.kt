package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class PatientActivity : AppCompatActivity() {

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun confirmationMessage(){
        showMessage("Mood send for analysis!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient)

        val menuBtn = findViewById<ImageButton>(R.id.goToMenuBtn)
        val terribleBtn = findViewById<Button>(R.id.terribleMoodBtn)
        val hardBtn = findViewById<Button>(R.id.hardMoodBtn)
        val normalBtn = findViewById<Button>(R.id.normalMoodBtn)
        val okBtn = findViewById<Button>(R.id.okMoodBtn)
        val goodBtn = findViewById<Button>(R.id.goodMoodBtn)
        val amazingBtn = findViewById<Button>(R.id.amazingMoodBtn)

        //going to menu
        menuBtn.setOnClickListener {
            val intentGoToMenuFromPatient = Intent(this, MenuActivity::class.java)
            startActivity(intentGoToMenuFromPatient)
            finish()
        }

        //while clicking on the terrible mood
        terribleBtn.setOnClickListener {
            confirmationMessage()
        }

        //while clicking on the hard mood
        hardBtn.setOnClickListener {
            confirmationMessage()
        }

        //while clicking on the normal mood
        normalBtn.setOnClickListener {
            confirmationMessage()
        }

        //while clicking on the ok mood
        okBtn.setOnClickListener {
            confirmationMessage()
        }

        //while clicking on the good mood
        goodBtn.setOnClickListener {
            confirmationMessage()
        }

        //while clicking on the amazing mood
        amazingBtn.setOnClickListener {
            confirmationMessage()
        }

    }
}