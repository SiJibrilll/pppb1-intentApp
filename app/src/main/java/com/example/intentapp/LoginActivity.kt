package com.example.intentapp // Replace with your actual package name

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var cbRemember: CheckBox
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView
    private lateinit var tvForgotPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        cbRemember = findViewById(R.id.cbRemember)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegister = findViewById(R.id.tvRegister)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)

        // Login button click
        btnLogin.setOnClickListener {
            loginUser()
        }

        // Register text click
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Forgot password click
        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot password clicked", Toast.LENGTH_SHORT).show()
            // You can implement forgot password functionality here
        }
    }

    private fun loginUser() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Validation
        when {
            username.isEmpty() -> {
                etUsername.error = "Username is required"
                etUsername.requestFocus()
                return
            }
            password.isEmpty() -> {
                etPassword.error = "Password is required"
                etPassword.requestFocus()
                return
            }
        }

        // Accept any username/password for demo purposes
        val intent = Intent(this, HomepageActivity::class.java).apply {
            putExtra("username", username)
            putExtra("email", "$username@example.com") // Generate email based on username
            putExtra("phone", "+123456789") // Mock phone
            putExtra("from", "login")
            putExtra("remember", cbRemember.isChecked)
        }
        startActivity(intent)
        finish() // Close login activity
    }
}