package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.camera_icon
import fooddelivery.composeapp.generated.resources.profile_image
import org.example.food.CommonUI.AppButton
import org.example.food.CommonUI.AppToolbar
import org.example.food.CommonUI.CommonTextView
import org.example.food.CommonUI.GenderRadioGroup
import org.example.food.CommonUI.MyOutlinedTextField
import org.jetbrains.compose.resources.painterResource

@Composable
fun RegisterProfileScreen(onClick:()-> Unit){

    var name by rememberSaveable{ mutableStateOf("") }
    var email by rememberSaveable{ mutableStateOf("") }
    var selectedGender by rememberSaveable { mutableStateOf("Male") }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Scaffold(
            topBar = {
                AppToolbar(
                    title = "",
                    onBackClick = {
                        println("Back clicked")

                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.fillMaxWidth()){


                    CommonTextView(
                        text = "Profile",
                        paddingStart = 16.dp,
                        paddingEnd = 0.dp,
                        paddingTop = 0.dp,
                        paddingBottom = 0.dp,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        modifier = Modifier.padding(top=0.dp).fillMaxWidth()
                    )

                    CommonTextView(
                        text = "Add Your Details",
                        paddingStart = 16.dp,
                        paddingEnd = 0.dp,
                        paddingTop = 10.dp,
                        paddingBottom = 0.dp,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        modifier = Modifier.padding(top=0.dp).fillMaxWidth()

                    )

                        Box(modifier = Modifier.padding(top = 20.dp).align(Alignment.CenterHorizontally).clip(CircleShape)){
                            Image(painterResource(Res.drawable.profile_image),contentDescription = null, modifier = Modifier.size(100.dp))
                            Image(painterResource(Res.drawable.camera_icon),contentDescription = null, modifier = Modifier.size(20.dp).align(Alignment.BottomCenter))
                        }

                    MyOutlinedTextField(
                        value = name,
                        onValueChange = { newText ->
                            if (newText.all { it.isLetterOrDigit() }) {
                                name = newText
                            }
                        },
                        placeholder = "Enter Name",
                        placeholderColor = Color.Black,
                        textColor = Color.Black,
                        borderColor = Color.Black, // Dark pink as hex
                        paddingStart = 16.dp,
                        paddingEnd = 16.dp,
                        paddingTop = 26.dp,
                        paddingBottom = 0.dp,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    MyOutlinedTextField(
                        value = email,
                        onValueChange = { newText ->
                            if (newText.all { it.isLetterOrDigit() }) {
                                email = newText
                            }
                        },
                        placeholder = "Enter Email",
                        placeholderColor = Color.Black,
                        textColor = Color.Black,
                        borderColor = Color.Black, // Dark pink as hex
                        paddingStart = 16.dp,
                        paddingEnd = 16.dp,
                        paddingTop = 26.dp,
                        paddingBottom = 0.dp,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )

                    CommonTextView(
                        text = "Select Gender",
                        paddingStart = 16.dp,
                        paddingEnd = 0.dp,
                        paddingTop = 10.dp,
                        paddingBottom = 0.dp,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        modifier = Modifier.padding(top=10.dp).fillMaxWidth()

                    )

                    GenderRadioGroup(
                        selectedGender = selectedGender,
                        onGenderSelected = { selectedGender = it }
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    AppButton(
                        title = "Submit",
                        background = Color(0xFFFC6011),
                        textColor = Color.White,
                        paddingStart = 16.dp,
                        paddingEnd = 16.dp,
                        paddingTop = 16.dp,
                        paddingBottom = 0.dp,

                        onClick = {
                            onClick()
                        }
                    )


                }
                }
            }

        }


}