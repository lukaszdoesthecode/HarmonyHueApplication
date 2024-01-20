package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    private lateinit var ageEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var sexualOrientationRadioGroup: RadioGroup
    private lateinit var therapyRadioGroup: RadioGroup
    private lateinit var symptomsRadioGroup: RadioGroup
    private lateinit var passOutRadioGroup: RadioGroup
    private lateinit var selfHarmRadioGroup: RadioGroup
    private lateinit var deadThoughtsRadioGroup: RadioGroup
    private lateinit var suicideAttemptRadioGroup: RadioGroup
    private lateinit var communicationDifficultyRadioGroup: RadioGroup
    private lateinit var eatingInPublicRadioGroup: RadioGroup
    private lateinit var beingObservedFeelingRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        ageEditText = findViewById(R.id.ageEditText)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        sexualOrientationRadioGroup = findViewById(R.id.sexualOrientationRadioGroup)
        therapyRadioGroup = findViewById(R.id.therapyRadioGroup)
        symptomsRadioGroup = findViewById(R.id.symptomsRadioGroup)
        passOutRadioGroup = findViewById(R.id.passOutRadioGroup)
        selfHarmRadioGroup = findViewById(R.id.selfHarmRadioGroup)
        deadThoughtsRadioGroup = findViewById(R.id.deathThoughtsRadioGroup)
        suicideAttemptRadioGroup = findViewById(R.id.suicideAttemptRadioGroup)
        communicationDifficultyRadioGroup = findViewById(R.id.communicationDifficultyRadioGroup)
        eatingInPublicRadioGroup = findViewById(R.id.eatingInPublicIssueRadioGroup)
        beingObservedFeelingRadioGroup = findViewById(R.id.beingObservedFeelingRadioGroup)

        val submitButton: Button = findViewById(R.id.submitSurveyButton)
        submitButton.setOnClickListener{
            if (areAllGroupsFilled()) {
                // All radio groups are filled, proceed with submission
                Toast.makeText(this, "Survey submitted successfully", Toast.LENGTH_SHORT).show()
                val intentToPatient= Intent(this, FindTherapistActivity::class.java)
                startActivity(intentToPatient)
            } else {
                // Display an error message if any radio group is not filled
                Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun areAllGroupsFilled(): Boolean {
        val ageInput: String = ageEditText.text.toString()
        return isRadioGroupFilled(genderRadioGroup) &&
                isRadioGroupFilled(sexualOrientationRadioGroup) &&
                isRadioGroupFilled(therapyRadioGroup) &&
                isRadioGroupFilled(symptomsRadioGroup) &&
                isRadioGroupFilled(passOutRadioGroup) &&
                isRadioGroupFilled(selfHarmRadioGroup) &&
                isRadioGroupFilled(deadThoughtsRadioGroup) &&
                isRadioGroupFilled(suicideAttemptRadioGroup) &&
                isRadioGroupFilled(communicationDifficultyRadioGroup) &&
                isRadioGroupFilled(eatingInPublicRadioGroup) &&
                isRadioGroupFilled(beingObservedFeelingRadioGroup) &&
                ageInput.isNotEmpty()
    }

    private fun isRadioGroupFilled(radioGroup: RadioGroup): Boolean {
        return radioGroup.checkedRadioButtonId != -1
    }
}