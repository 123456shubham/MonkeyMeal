package org.example.food

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.food.UI.CartItemRow
import org.example.food.UI.CartItemScreen
import org.example.food.UI.MenuRestaurentsScreen
import org.example.food.UI.MenuScreen
import org.example.food.UI.OnBoardingScreen
import org.example.food.UI.ProductDetails
import org.example.food.UI.ProfileScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.food.UI.RegisterProfileScreen
import org.example.food.UI.SendOTPScreen
import org.example.food.UI.SplashScreen
import org.example.food.UI.VerifyOTPScreen
import org.example.food.navigation.AppNavigation
import org.example.food.navigation.AppScreen

@Composable
@Preview
fun App() {

//    CartItemScreen()

    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination =  AppScreen.SPLASH_SCREEN
        ) {

            // Splash Screen
//            composable<AppScreen.SPLASH_SCREEN> {
//                SplashScreen(modifier = Modifier.fillMaxSize()) {
//                    navController.navigate(AppScreen.SEND_OTP) {
//                        popUpTo(AppScreen.SPLASH_SCREEN) { inclusive = true }
//                        launchSingleTop = true
//                    }
//                }
//            }

            // Splash
            composable<AppScreen.SPLASH_SCREEN> {
                SplashScreen(
                    modifier = Modifier.fillMaxSize(),
                    onFinish = {
                        navController.navigate(AppScreen.ON_BOARDING) {
                            popUpTo(AppScreen.SPLASH_SCREEN) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }
            // OnBoarding
            composable<AppScreen.ON_BOARDING> {
                OnBoardingScreen(
                    onFinish = {
                        navController.navigate(AppScreen.SEND_OTP) {
                            popUpTo(AppScreen.ON_BOARDING) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }


            // Send OTP
            composable<AppScreen.SEND_OTP> {
                SendOTPScreen { phoneNumber ->
                    navController.navigate(AppScreen.VERIFY_OTP(phoneNumber))
                }
            }

            // Verify OTP
            composable<AppScreen.VERIFY_OTP> { backStackEntry ->
                val args = backStackEntry.toRoute<AppScreen.VERIFY_OTP>()
                VerifyOTPScreen(phoneNumber = args.phoneNumber) {
                    navController.navigate(AppScreen.REGISTER_PROFILE)
                }
            }


            // Register
            composable<AppScreen.REGISTER_PROFILE> {

                RegisterProfileScreen {
                    navController.navigate(AppScreen.App_Navigation) {
                        popUpTo(AppScreen.SPLASH_SCREEN) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            }
            // Bottom-bar container. We pass a lambda that navigates with the *outer* controller.
            composable<AppScreen.App_Navigation> {
                AppNavigation(
                    onOpenRestaurants = { menuName ->
                        navController.navigate(AppScreen.RestaurantsLIST(menuName))
                    }
                )
            }


            // Restaurant List Screen → Product Details
            composable<AppScreen.RestaurantsLIST> { backStackEntry ->
                val args = backStackEntry.toRoute<AppScreen.RestaurantsLIST>()
                MenuRestaurentsScreen(args.name) { selectedProductName ->
                    navController.navigate(AppScreen.ProductDetails(selectedProductName))
                }
            }

// Product Details Screen
            composable<AppScreen.ProductDetails> { backStackEntry ->
                val args = backStackEntry.toRoute<AppScreen.ProductDetails>()
                ProductDetails(args.name) {
                    // For example, after clicking "Add to Cart", go back or somewhere else
                    navController.popBackStack().toString()
                }
            }





        }
    }
}
