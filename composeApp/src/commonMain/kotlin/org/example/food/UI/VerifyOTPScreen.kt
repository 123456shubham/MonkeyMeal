package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.app_logo
import fooddelivery.composeapp.generated.resources.welcome_top_shape
import kotlinx.coroutines.launch
import org.example.food.CommonUI.AppButton
import org.example.food.CommonUI.CommonTextView
import org.example.food.CommonUI.OtpView
import org.example.food.CommonUI.isValidOTP
import org.example.food.ViewModel.AuthViewModel
import org.jetbrains.compose.resources.painterResource


@Composable
fun VerifyOTPScreen(phoneNumber: String, onClick: (String?) -> Unit) {
    val viewModel: AuthViewModel = viewModel()
    val errorMessage by viewModel.OTPErrorMessage.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    var otp by rememberSaveable { mutableStateOf("") }
    var isSendOtpClicked by rememberSaveable { mutableStateOf(false) }

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize().navigationBarsPadding()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(Res.drawable.welcome_top_shape),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Image(
                    painter = painterResource(Res.drawable.app_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = 0.dp)
                )
            }

            CommonTextView(
                text = "OTP Verification",
                modifier = Modifier.fillMaxWidth(),
                paddingStart = 16.dp,
                paddingTop = 20.dp,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )

            CommonTextView(
                text = "Enter the code from the SMS sent to \n+91 $phoneNumber",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center,
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
                onClick = {
                    if (isValidOTP(otp)) {
                        isSendOtpClicked = true
                        onClick(phoneNumber)
                    }else{
                        viewModel.validOTP(otp, onClick)
                        if (errorMessage.isNotEmpty()) {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = errorMessage,
                                    withDismissAction = true
                                )
                            }
                        }
                    }
                }
            )

        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}
