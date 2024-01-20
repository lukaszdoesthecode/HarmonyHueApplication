package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MenuActivity : AppCompatActivity() {

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun logOutMessage(){
        showMessage("Logging out...")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val homeBtn = findViewById<ImageButton>(R.id.homeBtn)
        val logOutBtn = findViewById<ImageButton>(R.id.logOutBtn)
        val goToCheckYourMedicationsBtn = findViewById<Button>(R.id.goToCheckYourMedicationsBtn)
        val goToYourTherapistBtn = findViewById<Button>(R.id.goToYourTherapistBtn)
        val goToTherapyApproachesBtn = findViewById<Button>(R.id.goToTherapyApproachesBtn)
        val goToNotificationsSettingsBtn = findViewById<Button>(R.id.goToNotificationsSettingsBtn)

        homeBtn.setOnClickListener {
            val intentGoPatientFromMenu = Intent(this, PatientActivity::class.java)
            startActivity(intentGoPatientFromMenu)
            finish()
        }

        logOutBtn.setOnClickListener {
            logOutMessage()
            val intentLogout = Intent(this, MainActivity::class.java)
            startActivity(intentLogout)
            finish()

        }

        goToCheckYourMedicationsBtn.setOnClickListener {
            val intentGoToCheckYourMedicationsBtn = Intent(this, CheckMedicationsActivity::class.java)
            startActivity(intentGoToCheckYourMedicationsBtn)
            finish()
        }

        goToYourTherapistBtn.setOnClickListener {
            val intentGoToYourTherapistBtn = Intent(this, DisplayTherapist::class.java)
            startActivity(intentGoToYourTherapistBtn)
            finish()
        }

        goToTherapyApproachesBtn.setOnClickListener {
            val intentGoToTherapyApproachesBtn = Intent(this, TherapyTypesActivity::class.java)
            startActivity(intentGoToTherapyApproachesBtn)
            finish()
        }

        goToNotificationsSettingsBtn.setOnClickListener {
            // under construction
        }
    }
}