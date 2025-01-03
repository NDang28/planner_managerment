package com.example.planner_managerment_io.util

object StringUtil {
    fun isNullOrEmpty(str: String?): Boolean {
        return str.isNullOrEmpty()
    }

    fun isBlank(str: String?): Boolean {
        return str.isNullOrBlank()
    }

    fun trim(str: String?): String? {
        return str?.trim()
    }

    fun isValidEmail(email: String?): Boolean {
        return email?.matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) ?: false
    }
}