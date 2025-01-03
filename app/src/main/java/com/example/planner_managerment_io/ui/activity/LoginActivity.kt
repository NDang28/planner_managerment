package com.example.planner_managerment_io.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.planner_managerment_io.MainActivity
import com.example.planner_managerment_io.databinding.ActivityLoginBinding
import com.example.planner_managerment_io.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loading: TextView
    private lateinit var errorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initEvent()

    }

    private fun initView() {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        usernameInput = binding.usernameInput
        passwordInput = binding.passwordInput
        loading = binding.loading
        errorText = binding.errorText

    }

    private fun initEvent() {
        viewModel.loginResult.observe(this) {
            if (it != null) {
                Toast.makeText(this, "Login success ${it.token}", Toast.LENGTH_LONG).show();
                viewModel.clear();
                goToMainActivity()

            }
        }
        viewModel.errorMessage.observe(this) {
            if (it != null) {
                errorText.text = it
            } else {
                errorText.text = "";
            }

        }
        viewModel.loading.observe(this) {
            if (it) {
                loading.text = "Loading..."
            } else {
                loading.text = ""
            }
        }

        binding.btnLogin.setOnClickListener {
            viewModel.clearError()
            val username = usernameInput.text.toString();
            val password = passwordInput.text.toString();
            viewModel.login(username, password)
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}