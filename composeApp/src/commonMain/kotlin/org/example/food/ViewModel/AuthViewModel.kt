package org.example.food.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.example.food.CommonUI.isValidMobileNumber

class AuthViewModel : ViewModel(){

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    fun validateAndSendOtp(mobileNumber: String, onPhoneNumberEntered: (String) -> Unit) {
        if (isValidMobileNumber(mobileNumber)) {
            onPhoneNumberEntered(mobileNumber)
            _errorMessage.value = "" // clear old error
        } else {
            _errorMessage.value = "Please enter a valid 10-digit mobile number"
        }
    }
}