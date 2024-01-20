package com.lottoapp.harmonyhue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var inputLogin: EditText
    private lateinit var inputPassword: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Initializing firebase
        auth = FirebaseAuth.getInstance()

        inputLogin = findViewById(R.id.nameED)
        inputPassword = findViewById(R.id.passwordEDlogin)

        val btnRegister = findViewById<Button>(R.id.btnRegisterRA)
        val btnRegisterToLogin = findViewById<Button>(R.id.btnLogInRA)

        btnRegister.setOnClickListener{
            registerUser()
        }

        btnRegisterToLogin.setOnClickListener{
            // Simply finish this activity to go back to the previous one
            finish()
        }
    }
    private fun registerUser() {
        val email = inputLogin.text.toString().trim()
        val password = inputPassword.text.toString().trim()

        if (email.isBlank() || password.isBlank()) {
            showMessage("Please fill in all fields")
            return
        }


        // Firebase registration
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registration success, proceed to next activity
                    showMessage("Registration Successful")
                    val intent = Intent(this, RulesActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Show error message for registration failure
                    showMessage("Registration Failed: ${task.exception?.message}")
                }
            }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
