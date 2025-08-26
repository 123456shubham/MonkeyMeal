package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.btn_next
import fooddelivery.composeapp.generated.resources.menu_1
import fooddelivery.composeapp.generated.resources.menu_2
import fooddelivery.composeapp.generated.resources.menu_3
import fooddelivery.composeapp.generated.resources.menu_4
import fooddelivery.composeapp.generated.resources.offer_1
import fooddelivery.composeapp.generated.resources.offer_2
import fooddelivery.composeapp.generated.resources.offer_3
import fooddelivery.composeapp.generated.resources.search
import fooddelivery.composeapp.generated.resources.shopping_cart
import org.example.food.CommonUI.CommonTextView
import org.example.food.CommonUI.MyOutlinedTextField
import org.example.food.Model.Categoryitem
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource


@Composable
fun MenuScreen(onClick: (String) -> Unit) {
    val searchItem by rememberSaveable { mutableStateOf("") }
    val offers = listOf(
        Categoryitem("Food",  Res.drawable.menu_1),
        Categoryitem("Beverages",  Res.drawable.menu_2),
        Categoryitem("Desserts",  Res.drawable.menu_3),
        Categoryitem("Promotions",  Res.drawable.menu_4),
        Categoryitem("Chines",  Res.drawable.menu_1),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.White)
            .statusBarsPadding()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                CommonTextView(
                    "Menu",
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Image(
                    painterResource(Res.drawable.shopping_cart),
                    contentDescription = "Cart",
                    modifier = Modifier.size(24.dp),

                    )
            }

            // Search bar
            MyOutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp),
                value = searchItem,
                onValueChange = { },
                placeholder = "Search Food",
                placeholderColor = AppColor.placeholderBorderColour,
                textColor = AppColor.primaryTextColor,
                borderColor = AppColor.placeholderBorderColour
            ) {
                Image(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = "Search"
                )
            }

            // Orange strip + menu list
            Row(modifier = Modifier.fillMaxWidth()) {
                // Orange strip
                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(100.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp))
                        .background(AppColor.Orange)
                )

                // Menu list
                LazyColumn(
                    modifier = Modifier.weight(1f).padding(top = 20.dp).offset(x=(-50).dp) // take remaining width
                ) {
                    items(offers.size) {ite->
                        MenuItem(offers[ite],onClick)
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItem(
    categoryitem: Categoryitem,
    onClick: (String) -> Unit?

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp).
            clickable { onClick(categoryitem.name) }
    ) {
        // Card shifted so it starts around half the orange strip
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColor.White)
                    .padding(start = 50.dp, end = 12.dp, top = 12.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f).padding(vertical = 12.dp)) {
                    CommonTextView(
                        text = categoryitem.name,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = AppColor.primaryTextColor
                        )
                    )
//                    CommonTextView(
//                        text = subtitle,
//                        style = TextStyle(
//                            fontSize = 14.sp,
//                            color = AppColor.placeholderBorderColour
//                        )
//                    )
                }

                Image(painterResource(Res.drawable.btn_next),contentDescription = null)
            }
        }

        // Elevated circular image
        Card(
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.CenterStart)
                .offset(x = (-30).dp), // 👈 also overlap half into orange box
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Image(
                painter = painterResource(categoryitem.image),
                contentDescription = null,
                modifier = Modifier.background(Color.White),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}






