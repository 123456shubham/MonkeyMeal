package org.example.food.navigation

import kotlinx.serialization.Serializable

sealed interface AppScreen {

    @Serializable
    data object SPLASH_SCREEN: AppScreen

    @Serializable
    data object SEND_OTP: AppScreen

    @Serializable
    data class VERIFY_OTP(val phoneNumber: String): AppScreen

    @Serializable
    data object REGISTER_PROFILE: AppScreen

    @Serializable
    data object ON_BOARDING: AppScreen

    @Serializable
    data object HomeScreen : AppScreen

    @Serializable
    data object App_Navigation : AppScreen

    @Serializable
    data object Menu : AppScreen

    @Serializable
    data class RestaurantsLIST(val name: String) : AppScreen

    @Serializable
    data class ProductDetails(val name: String): AppScreen



}