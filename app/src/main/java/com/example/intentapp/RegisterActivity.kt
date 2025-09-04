package com.example.intentapp // Replace with your actual package name

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var cbTerms: CheckBox
    private lateinit var btnRegister: Button
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        cbTerms = findViewById(R.id.cbTerms)
        btnRegister = findViewById(R.id.btnRegister)
        tvLogin = findViewById(R.id.tvLogin)

        // Register button click
        btnRegister.setOnClickListener {
            registerUser()
        }

        // Login text click
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser() {
        val username = etUsername.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Validation
        when {
            username.isEmpty() -> {
                etUsername.error = "Username is required"
                etUsername.requestFocus()
                return
            }
            email.isEmpty() -> {
                etEmail.error = "Email is required"
                etEmail.requestFocus()
                return
            }
            phone.isEmpty() -> {
                etPhone.error = "Phone is required"
                etPhone.requestFocus()
                return
            }
            password.isEmpty() -> {
                etPassword.error = "Password is required"
                etPassword.requestFocus()
                return
            }
            !cbTerms.isChecked -> {
                Toast.makeText(this, "Please accept Terms and Conditions", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // If validation passes, go to homepage with user data
        val intent = Intent(this, HomepageActivity::class.java).apply {
            putExtra("username", username)
            putExtra("email", email)
            putExtra("phone", phone)
            putExtra("from", "register")
        }
        startActivity(intent)
        finish() // Close register activity
    }
}