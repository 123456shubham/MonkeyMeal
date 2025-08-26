package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.app_logo
import fooddelivery.composeapp.generated.resources.welcome_top_shape
import org.example.food.CommonUI.AppButton
import org.example.food.CommonUI.CommonTextView
import org.example.food.CommonUI.OtpView
import org.jetbrains.compose.resources.painterResource


@Composable
fun VerifyOTPScreen(phoneNumber: String,onClick:(String?)-> Unit){

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().height(400.dp)){

            Image(
                painter = painterResource(Res.drawable.welcome_top_shape),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            // Logo on top, overlapping near bottom center
            Image(
                painter = painterResource(Res.drawable.app_logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 0.dp) // Positive offset pushes it downward
            )
        }

        var otp by rememberSaveable { mutableStateOf("") }
//        val loginManager= LoginManager(LocalContext.current)
//        val repoState = viewModel.verifyOTPObservable.collectAsState().value
        var isSendOtpClicked by rememberSaveable { mutableStateOf(false) }
//        val context=LocalContext.current

        CommonTextView(
            text = "OTP Verification",
            modifier = Modifier.fillMaxWidth(),
            paddingStart = 16.dp,
            paddingEnd = 0.dp,
            paddingTop = 20.dp,
            paddingBottom = 0.dp,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            maxLines = 2,
        )

        CommonTextView(
            text = "Enter the code from the sms we want to \n +91 ${phoneNumber} ",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            paddingStart = 16.dp,
            paddingEnd = 0.dp,
            paddingTop = 20.dp,
            paddingBottom = 0.dp,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            textAlign = TextAlign.Center,
            maxLines = 2,

            )
        OtpView(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            otpText = otp,
            charColor = Color.Black,
            charBackground = Color.Transparent,
            charSize = 20.sp,
            otpCount = 4,
            onOtpTextChange = { otp = it }
        )

        AppButton(
            title = "Verify OTP",
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally),
            background = Color(0xFFFC6011),
            textColor = Color.White,
            paddingStart = 16.dp,
            paddingEnd = 16.dp,
            paddingTop = 16.dp,
            paddingBottom = 0.dp,
            onClick = {
                isSendOtpClicked=true
                onClick(phoneNumber)
            }
        )



    }

}