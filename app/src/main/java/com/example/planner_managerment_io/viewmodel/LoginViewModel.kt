package com.example.planner_managerment_io.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planner_managerment_io.data.model.LoginRequest
import com.example.planner_managerment_io.data.model.LoginResponse
import com.example.planner_managerment_io.data.repository.AuthRepository
import com.example.planner_managerment_io.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository = AuthRepositoryImpl()) :
    ViewModel() {
    private val _loginResult = MutableLiveData<LoginResponse?>()
    val loginResult: LiveData<LoginResponse?> = _loginResult

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                _loading.value = true;
                val loginRequest = LoginRequest(username, password);
                val result = authRepository.login(loginRequest)
                _loginResult.value = result;
            } catch (e: Exception) {
                _errorMessage.value = "Login failed ${e.message}";
            } finally {
                _loading.value = false;
            }
        }
    }

    fun clear() {
        _loginResult.value = null
    }

    fun clearError() {
        _errorMessage.value = null;
    }
}