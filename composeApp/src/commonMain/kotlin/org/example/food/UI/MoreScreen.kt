package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.btn_next
import fooddelivery.composeapp.generated.resources.menu_1
import fooddelivery.composeapp.generated.resources.more_inbox
import fooddelivery.composeapp.generated.resources.more_info
import fooddelivery.composeapp.generated.resources.more_my_order
import fooddelivery.composeapp.generated.resources.more_notification
import fooddelivery.composeapp.generated.resources.shopping_cart
import org.example.food.CommonUI.AppButton
import org.example.food.CommonUI.CommonTextView
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun MoreScreen(){
    Box(modifier = Modifier.fillMaxSize().background(color = AppColor.White).statusBarsPadding()){
        Column {
            Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {

                CommonTextView(
                    "More",
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

            Card( modifier = Modifier
                .fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AppColor.White // 👈 background color of card
                ),
                elevation = CardDefaults.cardElevation(6.dp)) {

                Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {

                    Card(
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.CenterVertically),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(
                            containerColor = AppColor.Orange // 👈 background color of card
                        ),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.more_my_order),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize().padding(15.dp).size(20.dp)
                            ,
                            colorFilter = ColorFilter.tint(Color.White) // 👈 makes image white

//                            contentScale = ContentScale.Crop
                        )
                    }
                    CommonTextView("My Orders", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(start = 10.dp).weight(1f).align(
                        Alignment.CenterVertically))
                    Image(painterResource(Res.drawable.btn_next),contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
                }
            }

            Card( modifier = Modifier
                .fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AppColor.White // 👈 background color of card
                ),
                elevation = CardDefaults.cardElevation(6.dp)) {

                Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {

                    Card(
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.CenterVertically),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(
                            containerColor = AppColor.Orange // 👈 background color of card
                        ),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.more_notification),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize().padding(15.dp).size(20.dp)
                            ,
                            colorFilter = ColorFilter.tint(Color.White) // 👈 makes image white

//                            contentScale = ContentScale.Crop
                        )
                    }
                    CommonTextView("Notification", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(start = 10.dp).weight(1f).align(
                        Alignment.CenterVertically))
                    Image(painterResource(Res.drawable.btn_next),contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
                }
            }

            Card( modifier = Modifier
                .fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AppColor.White // 👈 background color of card
                ),
                elevation = CardDefaults.cardElevation(6.dp)) {

                Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {

                    Card(
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.CenterVertically),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(
                            containerColor = AppColor.Orange // 👈 background color of card
                        ),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.more_inbox),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize().padding(15.dp).size(20.dp)
                            ,
                            colorFilter = ColorFilter.tint(Color.White) // 👈 makes image white

//                            contentScale = ContentScale.Crop
                        )
                    }
                    CommonTextView("Chat", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(start = 10.dp).weight(1f).align(
                        Alignment.CenterVertically))
                    Image(painterResource(Res.drawable.btn_next),contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
                }
            }

            Card( modifier = Modifier
                .fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AppColor.White // 👈 background color of card
                ),
                elevation = CardDefaults.cardElevation(6.dp)) {

                Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {

                    Card(
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.CenterVertically),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(
                            containerColor = AppColor.Orange // 👈 background color of card
                        ),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.more_info),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize().padding(15.dp).size(20.dp)
                            ,
                            colorFilter = ColorFilter.tint(Color.White) // 👈 makes image white

//                            contentScale = ContentScale.Crop
                        )
                    }
                    CommonTextView("Aboutus", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AppColor.primaryTextColor, modifier = Modifier.padding(start = 10.dp).weight(1f).align(
                        Alignment.CenterVertically))
                    Image(painterResource(Res.drawable.btn_next),contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
                }
            }

        }

    }
}
