
package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RulesActivity : AppCompatActivity() {
    private lateinit var btnGoToSurvey: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        btnGoToSurvey = findViewById(R.id.btnGoToSurvey)

        btnGoToSurvey.setOnClickListener{
            val intentGoToSurvey = Intent(this, FormActivity::class.java)
            startActivity(intentGoToSurvey)
        }
    }
}