package com.example.bakery.utils

import android.content.Context
import android.location.Geocoder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object MyUtils {

    private var isBottomSheetOpen = false

    suspend fun getAddressFromLocation(
        latitude: Double,
        longitude: Double,
        context: Context
    ): String? {
        return withContext(Dispatchers.IO) {  // Ensure it's running on IO thread
            try {
                val geocoder = Geocoder(context)
                val addresses = geocoder.getFromLocation(latitude, longitude, 1)
                if (addresses?.isNotEmpty() == true) {
                    addresses[0].getAddressLine(0)  // Return full address line
                } else {
                    "Address not found"
                }
            } catch (e: IOException) {
                e.printStackTrace()
                "Unable to fetch address"
            }
        }
    }

  /*  suspend fun getAddressFrom(
        latitude: Double,
        longitude: Double, context: Context
    ): LocationModel? {
        return withContext(Dispatchers.IO) {
            try {
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(latitude, longitude, 1)
                if (!addresses.isNullOrEmpty()) {
                    val address = addresses[0]
                    LocationModel(
                        lat = latitude.toString(),
                        long = longitude.toString(),
                        country = address.countryName ?: "",
                        state = address.adminArea ?: "",
                        city = address.subLocality ?: "",
                        pincode = address.postalCode ?: "",
                        line_1 = address.thoroughfare ?: "",
                        line_2 = address.featureName ?: ""
                    )
                } else {
                    null
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Error getting address: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                null
            }
        }
    }
*/


    fun convertedTime(input: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")

        val timeFormat = SimpleDateFormat("hh.mm a", Locale.getDefault())
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

        val date = inputFormat.parse(input) ?: return "Invalid Date"

        val formattedTime = timeFormat.format(date)
        val formattedDate = dateFormat.format(date)

        return "Time: $formattedTime | $formattedDate"
    }

    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return emailRegex.matches(email)
    }



}