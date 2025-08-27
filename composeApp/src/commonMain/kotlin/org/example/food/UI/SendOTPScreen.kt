package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
import org.example.food.CommonUI.MyOutlinedTextField
import org.example.food.CommonUI.isValidMobileNumber
import org.example.food.ViewModel.AuthViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun SendOTPScreen(onPhoneNumberEntered: (String) -> Unit) {
    val viewModel: AuthViewModel = viewModel()
    var mobileNumber by rememberSaveable { mutableStateOf("") }
    val errorMessage by viewModel.errorMessage.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Background Shape + Logo
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
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
                text = "Verify your Mobile Number",
                paddingStart = 16.dp,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                maxLines = 2,
                modifier = Modifier.padding(top = 30.dp)
            )

            CommonTextView(
                text = "We have sent you an OTP on this mobile number",
                paddingStart = 16.dp,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center,
                maxLines = 2,
                modifier = Modifier.padding(top = 20.dp)
            )

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
                borderColor = Color.Black,
                paddingStart = 16.dp,
                paddingEnd = 16.dp,
                paddingTop = 26.dp,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(10.dp))

            AppButton(
                title = "Send OTP",
                background = Color(0xFFFC6011),
                textColor = Color.White,
                paddingStart = 16.dp,
                paddingEnd = 16.dp,
                paddingTop = 16.dp,
                onClick = {
                    if (isValidMobileNumber(mobileNumber)) {
                        onPhoneNumberEntered(mobileNumber)
                    } else {
                        viewModel.validateAndSendOtp(mobileNumber, onPhoneNumberEntered)

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

        // Snackbar at Bottom
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}
