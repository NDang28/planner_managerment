package com.example.planner_managerment_io.data.repository

import com.example.planner_managerment_io.data.model.LoginRequest
import com.example.planner_managerment_io.data.model.LoginResponse

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): LoginResponse
}