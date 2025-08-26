package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.btn_back
import fooddelivery.composeapp.generated.resources.detail_top
import fooddelivery.composeapp.generated.resources.favorites_btn
import fooddelivery.composeapp.generated.resources.rate
import fooddelivery.composeapp.generated.resources.shopping_cart
import fooddelivery.composeapp.generated.resources.add
import fooddelivery.composeapp.generated.resources.favorites_btn_2
import fooddelivery.composeapp.generated.resources.minus
import fooddelivery.composeapp.generated.resources.more_inbox
import fooddelivery.composeapp.generated.resources.shopping_add
import org.example.food.CommonUI.AppButton
import org.example.food.CommonUI.CommonTextView
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource


@Composable
fun ProductDetails(name:String,productOnClick:()-> String) {
    var quantity by remember { mutableStateOf(1) }
    var isLiked by remember { mutableStateOf(false) }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            // 🔹 Top Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.detail_top),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Restaurant Image"
                )

                // 🔹 Back + Cart Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=30.dp, start = 20.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Image(
                        painter = painterResource(Res.drawable.btn_back),
                        contentDescription = "Back",
                        colorFilter = ColorFilter.tint(AppColor.White),
                        modifier = Modifier.size(24.dp)
                    )
                    Image(
                        painter = painterResource(Res.drawable.shopping_cart),
                        contentDescription = "Cart",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(AppColor.White)
                    )
                }
            }

            // 🔹 Card Section
            Box(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = (-20).dp), // overlap upwards
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        // Title
                        CommonTextView(
                            "Tandoori Chicken Pizza",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                        // 🔹 Rating Row
                        Row(
                            modifier = Modifier.padding(top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(5) {
                                Image(
                                    painter = painterResource(Res.drawable.rate),
                                    contentDescription = "Rating Star",
                                    modifier = Modifier.size(16.dp).padding(end = 2.dp),
                                    colorFilter = ColorFilter.tint(AppColor.Orange)
                                )
                            }
                            CommonTextView(
                                "5 Star Ratings",
                                modifier = Modifier.padding(start = 6.dp),
                                fontSize = 10.sp,
                                color = AppColor.Orange
                            )
                        }

                        // 🔹 Price aligned to end
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            CommonTextView(
                                "Rs. 750",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = AppColor.primaryTextColor
                            )
                        }

                        // 🔹 Description
                        CommonTextView(
                            "Description",
                            modifier = Modifier.padding(top = 16.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        CommonTextView(
                            text = "This Tandoori Chicken Pizza is baked to perfection with a spicy tandoori sauce, fresh vegetables, and tender chicken chunks. A perfect mix of Indian flavors on an Italian base. Served hot with extra cheese and seasoning.",
                            modifier = Modifier.padding(top = 6.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = AppColor.primaryTextColor
                        )

                        Divider(modifier = Modifier.padding(vertical = 16.dp))

                        // 🔹 Quantity Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CommonTextView(
                                text = "Number Of Portions",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AppColor.primaryTextColor
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Minus Button
                                Box(
                                    modifier = Modifier
                                        .size(40.dp) // final button size
                                        .clip(RoundedCornerShape(12.dp)) // 👈 radius (change dp for more/less roundness)
                                        .background(AppColor.Orange)
                                        .clickable {
                                            if (quantity > 1) quantity--
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(Res.drawable.minus), // minus icon
                                        contentDescription = "Decrease",
                                        colorFilter = ColorFilter.tint(AppColor.White),
                                        modifier = Modifier.size(20.dp) // icon size inside
                                    )
                                }

                                // Quantity Box with Border
                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .size(width = 56.dp, height = 40.dp) // fixed size for alignment
                                        .border(
                                            width = 2.dp,
                                            color = AppColor.Orange,
                                            shape = RoundedCornerShape(20.dp) // rounded edges
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CommonTextView(
                                        text = quantity.toString(),
                                        fontSize = when {
                                            quantity >= 10000 -> 12.sp
                                            quantity >= 1000 -> 14.sp
                                            else -> 16.sp
                                        },
                                        fontWeight = FontWeight.SemiBold,
                                        color = AppColor.primaryTextColor,
                                        maxLines = 1
                                    )
                                }

                                // Plus Button
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(12.dp)) // 👈 same radius
                                        .background(AppColor.Orange)
                                        .clickable { quantity++ },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(Res.drawable.add), // plus icon
                                        contentDescription = "Increase",
                                        colorFilter = ColorFilter.tint(AppColor.White),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }

                        }

                        Card(modifier = Modifier.fillMaxWidth().padding(start = 20.dp,end = 20.dp,top = 20.dp, bottom = 20.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White)

                        ) {

                            CommonTextView("Total Price", modifier = Modifier.fillMaxWidth().padding(top = 20.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            CommonTextView("Rs.${quantity*750}", modifier = Modifier.fillMaxWidth().padding(top = 20.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            AppButton("Add to Cart", modifier = Modifier.fillMaxWidth().padding(top = 20.dp).background(color = AppColor.Orange)){
                            }
                        }
                    }
                }

                Image( painter = painterResource(
                    if (isLiked) Res.drawable.favorites_btn_2 // ❤️ (liked icon)
                    else Res.drawable.favorites_btn           // 🤍 (outline icon)
                ), contentDescription = "Favorite",
                    modifier = Modifier .align(Alignment.TopEnd).clickable {isLiked = !isLiked   } .offset(y = (-40).dp, x = (-16).dp) )
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .offset(y = (-40).dp, x = (-16).dp)
//                        .clickable { isLiked = !isLiked }, // toggle like/dislike
//                    contentAlignment = Alignment.Center
//                ) {
//                    Image(
//                        painter = painterResource(
//                            if (isLiked) Res.drawable.favorites_btn // ❤️ (liked icon)
//                            else Res.drawable.favorites_btn_2           // 🤍 (outline icon)
//                        ),
//                        contentDescription = if (isLiked) "Unlike" else "Like",
//                        colorFilter = ColorFilter.tint(if (isLiked) Color.Red else Color.Gray),
//                        modifier = Modifier
//                    )
//                }
            }
        }
    }
}
