package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.rate
import org.example.food.CommonUI.CommonTextView
import org.example.food.Model.Categoryitem
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun RestaurentItem(restaurent: Categoryitem) {
    Box(modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(restaurent.image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            CommonTextView(
                restaurent.name,
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 16.sp,
                paddingStart = 10.dp,
                color = AppColor.primaryTextColor,
                fontWeight = FontWeight.Bold
            )
            Row(modifier = Modifier.padding(start = 10.dp, top = 5.dp)) {
                Image(
                    painterResource(Res.drawable.rate),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.padding(end = 5.dp).size(16.dp)
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
