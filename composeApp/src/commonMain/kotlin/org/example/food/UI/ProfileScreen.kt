package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.app_logo
import fooddelivery.composeapp.generated.resources.baseline_edit_24
import fooddelivery.composeapp.generated.resources.camera_icon
import fooddelivery.composeapp.generated.resources.profile_image
import fooddelivery.composeapp.generated.resources.shopping_cart
import fooddelivery.composeapp.generated.resources.tab_more
import org.example.food.CommonUI.CommonTextView
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileScreen(){
    Box(modifier = Modifier.fillMaxSize().background(color = AppColor.White).statusBarsPadding()){
        Column {
            Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {

                CommonTextView(
                    "Profile",
                    modifier = Modifier.weight(1f).padding(start = 10.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Image(
                    painterResource(Res.drawable.shopping_cart),
                    contentDescription = "Cart",
                    modifier = Modifier.size(24.dp)
                )
            }

            Box(modifier = Modifier.padding(top = 20.dp).align(Alignment.CenterHorizontally).clip(CircleShape)){
                Image(painterResource(Res.drawable.profile_image),contentDescription = null, modifier = Modifier.size(100.dp))
                Image(painterResource(Res.drawable.camera_icon),contentDescription = null, modifier = Modifier.size(20.dp).align(Alignment.BottomCenter))
            }

            Row(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp)) {
                Image(painterResource(Res.drawable.baseline_edit_24),contentDescription = null, modifier = Modifier.size(20.dp))
                CommonTextView("Edit Profile", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(start = 5.dp))
            }

            Card(modifier = Modifier
                .fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 30.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp),) {

                Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
                    CommonTextView("Name", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = AppColor.placeholderBorderColour)
                    CommonTextView("Shubham Chauhan", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(top = 5.dp))
                }

            }

            Card(modifier = Modifier
                .fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 20.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp),) {

                Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
                    CommonTextView("Phone", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = AppColor.placeholderBorderColour)
                    CommonTextView("8571056426", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(top = 5.dp))
                }

            }

            Card(modifier = Modifier
                .fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 20.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp),) {

                Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
                    CommonTextView("Email", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = AppColor.placeholderBorderColour)
                    CommonTextView("shubham@gmail.com", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(top = 5.dp))
                }

            }

            Card(modifier = Modifier
                .fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 20.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(6.dp),) {

                Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
                    CommonTextView("Address", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = AppColor.placeholderBorderColour)
                    CommonTextView("Delhi : 110036", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(top = 5.dp))
                }

            }
        }

    }

}