package com.example.bakery.utils

import android.content.Context

class NewUser(val context: Context) {

    private val sharedPreferences by lazy {
        context.getSharedPreferences("NewUser", Context.MODE_PRIVATE)
    }

    fun setNewUser(isNewUser: Boolean) {
        sharedPreferences.edit().putBoolean("isNewUser", isNewUser).apply()
    }

    fun isNewUser(): Boolean {
        return sharedPreferences.getBoolean("isNewUser", true)
    }

}