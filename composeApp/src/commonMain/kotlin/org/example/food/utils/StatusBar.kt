package org.example.food.utils

//import android.app.Activity
//import android.graphics.Color
//import android.os.Build
//import android.view.View
//import android.view.WindowInsetsController
//import androidx.core.content.ContextCompat
//import com.example.bakery.R

//object StatusBar {
//
//    fun whiteStatus(context: Activity) {
//        context.window.statusBarColor = ContextCompat.getColor(context, R.color.white)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            context.window.insetsController?.setSystemBarsAppearance(
//                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
//                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
//            )
//        } else {
//            @Suppress("DEPRECATION")
//            context.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }
//    }
//
//    fun blackStatus(context: Activity) {
//        val window = context.window
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            val controller = window.insetsController
//            controller?.setSystemBarsAppearance(0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
//            window.statusBarColor = Color.BLACK
//        } else {
//            @Suppress("DEPRECATION")
//            window.decorView.systemUiVisibility = 0
//            window.statusBarColor = Color.BLACK
//        }
//    }
//
//
//}