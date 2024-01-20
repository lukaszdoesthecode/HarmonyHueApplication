package com.lottoapp.harmonyhue

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class FindTherapistActivity : AppCompatActivity() {

    private lateinit var therapistName: EditText
    private lateinit var therapistSurname: EditText
    private lateinit var therapistPhoneNumber: EditText
    private lateinit var therapistEmail: EditText
    private lateinit var shakeToHelp: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_therapist)

        //declaration of button
        val goToPatientActivityBtn = findViewById<Button>(R.id.goToPatientActivityBtn)

        goToPatientActivityBtn.setOnClickListener{
            val intentToPatientFromRegistration = Intent(this, PatientActivity::class.java)
            startActivity(intentToPatientFromRegistration)
            finish()
        }
    }
}