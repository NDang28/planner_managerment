package com.example.planner_managerment_io.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateTimeUtil {
    private const val DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss"

    fun formatDate(date: Date, format: String = DEFAULT_FORMAT): String {
        val formatter = SimpleDateFormat(format, Locale.getDefault())
        return formatter.format(date)
    }

    fun parseDate(dateString: String, format: String = DEFAULT_FORMAT): Date? {
        val formatter = SimpleDateFormat(format, Locale.getDefault())
        return try {
            formatter.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }
}