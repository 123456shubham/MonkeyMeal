package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.offer_1
import fooddelivery.composeapp.generated.resources.offer_2
import fooddelivery.composeapp.generated.resources.offer_3
import fooddelivery.composeapp.generated.resources.rate
import fooddelivery.composeapp.generated.resources.shopping_cart
import org.example.food.CommonUI.AppButton
import org.example.food.CommonUI.CommonTextView
import org.example.food.Model.Categoryitem
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun OffersScreen() {

    val offerScreen=listOf(
        Categoryitem("Dosa Factory", Res.drawable.offer_1),
        Categoryitem("Dosa Factory", Res.drawable.offer_2),
        Categoryitem("Dosa Factory", Res.drawable.offer_3),

        )
    Box(modifier = Modifier.fillMaxSize().background(AppColor.White).statusBarsPadding()){

            LazyColumn (modifier = Modifier){
                item {
                    Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {

                        CommonTextView(
                            "Latest Offers",
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
                    CommonTextView("Find Discount, Offers Special \nMeals & More", fontSize = 14.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp))
                    AppButton(
                        title = "Check Offers",
                        background = Color(0xFFFC6011),
                        textColor = Color.White,
                        paddingStart = 16.dp,
                        paddingEnd = 16.dp,
                        paddingTop = 16.dp,
                        paddingBottom = 0.dp,
                        modifier = Modifier.width(200.dp),
                        onClick = {

                        }
                    )
                }
                items(offerScreen.size) {itr->
                    OfferItem(categoryitem = offerScreen[itr])
                }
            }
    }
}

@Composable
fun OfferItem(categoryitem: Categoryitem){
    Box(modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(categoryitem.image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            CommonTextView(
              "${categoryitem.name}",
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 16.sp,
                paddingStart = 10.dp,
                color = AppColor.primaryTextColor,
                fontWeight = FontWeight.Bold
            )
            Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                Image(
                    painterResource(Res.drawable.rate),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.padding(end = 10.dp).size(16.dp)
                )
                CommonTextView(
                    "4.9",
                    fontSize = 14.sp,
                    color = AppColor.Orange,
                    fontWeight = FontWeight.Bold
                )
                CommonTextView(
                    "(121 rating) Cafe Western Food ",
                    fontSize = 14.sp,
                    color = AppColor.placeholderBorderColour
                )
            }
        }
    }

}