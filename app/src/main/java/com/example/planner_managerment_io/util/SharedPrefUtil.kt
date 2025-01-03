package com.example.planner_managerment_io.util

import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.putString
import androidx.core.content.edit

object SharedPrefUtil {
    private const val PREF_NAME = "my_app_pref"
    fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    fun saveString(context: Context, key: String, value: String) {
        getPreferences(context).edit {
            putString(key, value)
        }
    }

    fun getString(context: Context, key: String, defaultValue: String = ""): String {
        return getPreferences(context).getString(key, defaultValue) ?: defaultValue
    }

    fun clearAll(context: Context) {
        getPreferences(context).edit().clear().apply();
    }
}