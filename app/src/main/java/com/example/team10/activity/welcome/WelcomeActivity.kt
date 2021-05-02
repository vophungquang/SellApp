package com.example.team10.activity.welcome

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.TextView
import com.example.team10.R
import com.example.team10.activity.signin.SignInActivity
import com.example.team10.activity.signup.SignUpActivity


class WelcomeActivity : AppCompatActivity() {
    private lateinit var btnStart : MaterialButton
    private lateinit var btnSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_welcome)
        findViewsById()
        setupViews()
    }

    private fun findViewsById(){
        btnStart = findViewById(R.id.signup)
        btnSignIn = findViewById(R.id.signin)
    }

    private fun setupViews(){
        btnStart.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}