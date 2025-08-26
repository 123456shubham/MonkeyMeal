package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.m_res_1
import fooddelivery.composeapp.generated.resources.m_res_2
import fooddelivery.composeapp.generated.resources.res_1
import fooddelivery.composeapp.generated.resources.res_2
import fooddelivery.composeapp.generated.resources.res_3
import fooddelivery.composeapp.generated.resources.search
import fooddelivery.composeapp.generated.resources.shopping_cart
import org.example.food.CommonUI.CommonTextView
import org.example.food.CommonUI.MyOutlinedTextField
import org.example.food.Model.Categoryitem
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val searchItem by rememberSaveable { mutableStateOf("") }
    val restaurentsImage = listOf(
        Categoryitem("Dosa Factory", Res.drawable.res_1),
        Categoryitem("Food Hub", Res.drawable.res_2),
        Categoryitem("Tandoori House", Res.drawable.res_3),
        Categoryitem("Spice Villa", Res.drawable.m_res_2),
    )

    LazyColumn(
        modifier = modifier.fillMaxSize().background(AppColor.White )
    ) {
        // 👇 Header section as first item
        item {
            Column(modifier.statusBarsPadding()) {
                Row(modifier.padding(10.dp)) {
                    CommonTextView(
                        "Good Morning Shubham Chauhan",
                        modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Image(
                        painterResource(Res.drawable.shopping_cart),
                        contentDescription = "Cart",
                        modifier.size(24.dp)
                    )
                }

                CommonTextView(
                    "Delivery to",
                    modifier.fillMaxWidth().padding(top = 20.dp, start = 10.dp),
                    fontSize = 12.sp,
                    color = AppColor.placeholderBorderColour
                )
                CommonTextView(
                    "757 Bhaktawarpur Tanda Delhi : 110036",
                    modifier.fillMaxWidth().padding(top = 2.dp, start = 10.dp),
                    fontSize = 16.sp,
                    color = AppColor.primaryTextColor
                )

                MyOutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp, start = 10.dp, end = 10.dp),
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

                HomeCategory()

                Row(modifier.padding(top = 30.dp,start = 10.dp, end = 10.dp)) {
                    CommonTextView(
                        "Popular Restaurants",
                        modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = AppColor.primaryTextColor
                    )
                    CommonTextView(
                        "View All",
                        fontSize = 16.sp,
                        color = AppColor.Orange
                    )
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    restaurentsImage.forEach { restaurent ->
                        RestaurentItem(restaurent)
                    }
                }
            }
        }




        // 👇 Restaurants list as items
//        items(restaurants) { restaurant ->
//            RestaurantCard(restaurant)
//        }
    }
}
