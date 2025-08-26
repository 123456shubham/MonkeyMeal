package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.app_logo
import fooddelivery.composeapp.generated.resources.splash_bg
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(modifier: Modifier, onFinish: () -> Unit){



    LaunchedEffect(true) {
        // simulate 3 sec delay
        kotlinx.coroutines.delay(3000)
        onFinish()
    }
    SplashScreenPreview()

}

@Composable
fun SplashScreenPreview(){
    Box(modifier = Modifier.fillMaxSize()){
        // Background image
        Image(
            painter = painterResource(Res.drawable.splash_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Foreground logo
        Image(
            painter = painterResource(Res.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}