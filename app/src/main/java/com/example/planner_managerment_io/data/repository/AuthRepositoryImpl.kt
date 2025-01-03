package com.example.planner_managerment_io.data.repository

import com.example.planner_managerment_io.data.model.LoginRequest
import com.example.planner_managerment_io.data.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl:AuthRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return withContext(Dispatchers.IO){
            // Handle call Api, data fetch from database....
            // Ex : Fake Data
            LoginResponse("token123",1);
        }
    }
}