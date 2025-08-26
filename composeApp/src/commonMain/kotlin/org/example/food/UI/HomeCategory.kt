package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.offer_1
import fooddelivery.composeapp.generated.resources.offer_2
import fooddelivery.composeapp.generated.resources.offer_3
import org.example.food.CommonUI.CommonTextView
import org.example.food.Model.Categoryitem
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeCategory(){
        val offers = listOf(
            Categoryitem("Offers",  Res.drawable.offer_1),
            Categoryitem("Sri Lankan",  Res.drawable.offer_2),
            Categoryitem("Italian",  Res.drawable.offer_3),
            Categoryitem("Indian",  Res.drawable.offer_3),
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(offers.size) { offer ->
                val category = offers[offer] // ✅ cleaner

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .wrapContentHeight()
                        .padding(top = 20.dp,start = 10.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(category.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                        CommonTextView(
                            text = "${category.name}",
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            paddingTop = 10.dp,
                            color = AppColor.primaryTextColor,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }





}