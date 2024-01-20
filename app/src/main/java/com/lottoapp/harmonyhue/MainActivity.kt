package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputLogin: EditText
    private lateinit var inputPassword: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //buttons
        val btnLogin = findViewById<Button>(R.id.btnLoginLoginBtn)
        val btnLoginToRegister = findViewById<Button>(R.id.btnRegisterLoginBtn)

        //initialing the FireBaseAuth
        auth = FirebaseAuth.getInstance()
        inputLogin = findViewById(R.id.nameED)
        inputPassword = findViewById(R.id.passwordEDlogin)

        //log in into the app
        btnLogin.setOnClickListener {
            logInRegisteredUser()
        }

        //going to register activity
        btnLoginToRegister.setOnClickListener {
            val intentToRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentToRegister)
            finish()
        }

    }

    private fun validateLoginDetails(): Boolean {
        return when {
            TextUtils.isEmpty(inputLogin.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar("Please enter your email.", true)
                false
            }

            TextUtils.isEmpty(inputPassword.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar("Please enter your password.", true)
                false
            }

            else -> {
                true
            }
        }
    }

    private fun logInRegisteredUser() {
        if (validateLoginDetails()) {
            val email = inputLogin.text.toString().trim { it <= ' ' }
            val password = inputPassword.text.toString().trim { it <= ' ' }

            // Authenticate with Firebase
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showErrorSnackBar("You are logged in successfully.", false)
                        goToNumbSelectionActivity() // TODO
                    } else {
                        showErrorSnackBar(task.exception?.message.toString(), true)
                    }
                }
        }
    }

    private fun goToNumbSelectionActivity() {
        val user = auth.currentUser
        val uid = user?.email.toString()

        val intentFromLoginToPatient = Intent(this, PatientActivity::class.java)
        intentFromLoginToPatient.putExtra("uID", uid)
        startActivity(intentFromLoginToPatient)
    }

    private fun showErrorSnackBar(message: String, isError: Boolean) {
        val snackBar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view

        if (isError) {
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.lavender)) // Replace with your error color
        } else {
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.mint)) // Replace with your success color
        }

        snackBar.show()
    }
}