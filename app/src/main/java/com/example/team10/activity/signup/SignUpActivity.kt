package com.example.team10.activity.signup

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.team10.R
import com.example.team10.activity.signin.SignInActivity
import com.example.team10.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_welcome.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setupViewModelBinding()

    }

    override fun onStop() {
        super.onStop()
        viewModel.clear()
    }

    private fun setupViewModelBinding() {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.lifecycleOwner = this
        binding.signUpViewModel = viewModel
        binding.apply {
            btnSignUp.setOnClickListener {
                startLoginActivity()
            }
        }

        viewModel.isSignUpSucceed.observe(this, Observer {
            it?.let {
                if (it) {
                    showToastMessage("Sign Up Successful")
                    startLoginActivity()
                }
            }
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            message?.let {
                Toast.makeText(this@SignUpActivity, message, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun startLoginActivity() {
        val intent = Intent(
            this@SignUpActivity,
            SignInActivity::class.java
        )
        startActivity(intent)
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}