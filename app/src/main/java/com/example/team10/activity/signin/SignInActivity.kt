package com.example.team10.activity.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.team10.Pants.PantsActivity
import com.example.team10.R
import com.example.team10.User
import com.example.team10.activity.profile.ProfileActivity
import com.example.team10.activity.signup.SignUpActivity
import com.example.team10.databinding.ActivitySignInBinding



class SignInActivity : AppCompatActivity() {

    companion object {
        const val USER_KEY = "USER_KEY"
    }

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel


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
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.lifecycleOwner = this
        binding.signInViewModel = viewModel
        binding.apply {
            btnSignIn.setOnClickListener {
                val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        viewModel.isSignInSucceed.observe(this, Observer { user ->
            user?.let {
                showToastMessage("Sign in Successful")
                startProfileActivity(user)
            }

        })

        viewModel.errorMessage.observe(this, Observer { message ->
            message?.let {
                showToastMessage(message)

            }
        })
    }

    private fun startProfileActivity(user: User) {
        val bundle = Bundle()
        bundle.putParcelable(USER_KEY, user)
        val intent = Intent(this@SignInActivity, PantsActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun showToastMessage(value: String) {
        Toast.makeText(this@SignInActivity, value, Toast.LENGTH_SHORT).show()
    }
}