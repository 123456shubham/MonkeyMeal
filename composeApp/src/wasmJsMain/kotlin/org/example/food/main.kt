package org.example.food

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.ComposeViewport
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.app_logo
import fooddelivery.composeapp.generated.resources.welcome_top_shape
import kotlinx.browser.document
import org.example.food.CommonUI.AppButton
import org.example.food.CommonUI.CommonTextView
import org.example.food.CommonUI.MyOutlinedTextField
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        SendOTPScreen()
    }
}



@Composable
fun SendOTPScreen(){
    var mobileNumber by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
        ) {
            // Background shape
            Image(
                painter = painterResource(Res.drawable.welcome_top_shape),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(500.dp),
//                contentScale = ContentScale
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

        MyOutlinedTextField(
            value = mobileNumber,
            onValueChange = { newText ->
                if (newText.all { it.isDigit() }) {
                    mobileNumber = newText
                }
            },
            placeholder = "Enter Mobile Number",
            placeholderColor = Color.Black,
            textColor = Color.Black,
            borderColor = Color.Black, // Dark pink as hex
            paddingStart = 16.dp,
            paddingEnd = 16.dp,
            paddingTop = 26.dp,
            paddingBottom = 0.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))
        AppButton(
            title = "Send OTP",
            background = Color(0xFFFC6011),
            textColor = Color.White,
            paddingStart = 16.dp,
            paddingEnd = 16.dp,
            paddingTop = 16.dp,
            paddingBottom = 0.dp,

            onClick = {
                if (mobileNumber.length == 10) {
//                    isSendOtpClicked = true
//                    viewModel.sendOTP(SendOTP("869133042958353", mobileNumber))
                } else {
//                    Toast.makeText(
//                        context,
//                        "Please enter valid mobile number",
//                        Toast.LENGTH_SHORT
//                    ).show()
                }
            }
        )

    }
}
