package com.example.intentapp // Replace with your actual package name

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomepageActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView
    private lateinit var tvEmailStatus: TextView
    private lateinit var tvPhoneStatus: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // Initialize views
        tvWelcome = findViewById(R.id.tvWelcome)
        tvEmailStatus = findViewById(R.id.tvEmailStatus)
        tvPhoneStatus = findViewById(R.id.tvPhoneStatus)
        btnLogout = findViewById(R.id.btnLogout)

        // Get data from intent
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val from = intent.getStringExtra("from")
        val remember = intent.getBooleanExtra("remember", false)

        // Set welcome message
        username?.let {
            tvWelcome.text = "Welcome $it"
        }

        // Set email status
        email?.let {
            tvEmailStatus.text = "Your $it has been activated"
        }

        // Set phone status
        phone?.let {
            tvPhoneStatus.text = "Your $it has been registered"
        }

        // Logout button click
        btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        // Clear any stored data if needed
        val intent = Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
}