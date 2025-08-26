package org.example.food.utils

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

class LoginManager private constructor(private val settings: Settings) {

    // Clear all stored data
    fun removeAll() {
        settings.clear()
    }

    // Login status
    fun setLoginStatus(isLoggedIn: Boolean) {
        settings[IS_LOGGED_IN] = isLoggedIn
    }

    fun isLoggedIn(): Boolean = settings.getBoolean(IS_LOGGED_IN, false)

    // Location
    fun setLocationLongitude(longitude: String) {
        settings[LOCATION_LONGITUDE] = longitude
    }

    fun getLocationLongitude(): String? = settings.getStringOrNull(LOCATION_LONGITUDE)

    fun setLocationLatitude(latitude: String) {
        settings[LOCATION_LATITUDE] = latitude
    }

    fun getLocationLatitude(): String? = settings.getStringOrNull(LOCATION_LATITUDE)

    // FCM token
    fun setFcmToken(fcmToken: String) {
        settings[FCM_TOKEN] = fcmToken
    }

    fun getFcmToken(): String? = settings.getStringOrNull(FCM_TOKEN)

    // Auth token
    fun setToken(tok: String) {
        settings[TOKEN] = tok
    }

    fun getToken(): String? = settings.getStringOrNull(TOKEN)

    // Address selection
    fun setAddressSelected(value: Boolean) {
        settings[IS_ADDRESS_SELECTED] = value
    }

    fun getAddressSelected(): Boolean = settings.getBoolean(IS_ADDRESS_SELECTED, false)

    // Phone
    fun setPhone(value: String?) {
        if (value != null) settings[PHONE] = value else settings.remove(PHONE)
    }

    fun getPhone(): String? = settings.getStringOrNull(PHONE)

    // WhatsApp
    fun setWhatsappNo(value: String?) {
        if (value != null) settings[WHATSAPP] = value else settings.remove(WHATSAPP)
    }

    fun getWhatsappNo(): String? = settings.getStringOrNull(WHATSAPP)

    // ✅ Onboarding tracking
    var isFirstLaunch: Boolean
        get() = settings.getBoolean(FIRST_LAUNCH, true)
        set(value) {
            settings[FIRST_LAUNCH] = value
        }

    companion object {
        private const val IS_LOGGED_IN = "isLogin"
        private const val TOKEN = "token"
        private const val PHONE = "phone"
        private const val WHATSAPP = "whatsapp"
        private const val IS_ADDRESS_SELECTED = "is_address_selected"
        private const val FCM_TOKEN = "fcmToken"
        private const val LOCATION_LATITUDE = "latitude"
        private const val LOCATION_LONGITUDE = "longitude"
        private const val FIRST_LAUNCH = "first_launch"

        // Singleton instance
        private var instance: LoginManager? = null

//        fun getInstance(settings: Settings = Settings()): LoginManager {
//            if (instance == null) {
//                instance = LoginManager(settings)
//            }
//            return instance!!
//        }
    }
}
