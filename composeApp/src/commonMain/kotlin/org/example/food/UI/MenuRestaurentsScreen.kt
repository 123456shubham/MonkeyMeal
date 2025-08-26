package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.btn_back
import fooddelivery.composeapp.generated.resources.rate
import fooddelivery.composeapp.generated.resources.res_1
import fooddelivery.composeapp.generated.resources.search
import fooddelivery.composeapp.generated.resources.shopping_cart
import org.example.food.CommonUI.CommonTextView
import org.example.food.CommonUI.MyOutlinedTextField
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun MenuRestaurentsScreen(menuName:String,onClick:(String)->Unit) {


    val searchItem by rememberSaveable { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.White)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Header
            Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {

                Image(
                    painterResource(Res.drawable.btn_back),
                    contentDescription = "back btn",
                    modifier = Modifier.size(18.dp)
                )
                CommonTextView(
                    "${menuName}",
                    modifier = Modifier.weight(1f).padding(start = 10.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Image(
                    painterResource(Res.drawable.shopping_cart),
                    contentDescription = "Cart",
                    modifier = Modifier.size(20.dp)
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


            LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
                items(10) {
                    MenuRestaurentsItem(onClick={onClick.invoke("Product Details")})
                }
            }
        }
    }


}

@Composable
fun MenuRestaurentsItem(onClick: (String) -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 10.dp)
            .clickable { onClick("Product Details") }
    ) {
        // Background Image
        Image(
            painter = painterResource(Res.drawable.res_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Title + Rating stacked together (bottom-left)
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 16.dp)
        ) {
            // Title
            CommonTextView(
                "Dark Chocolate Cake",
                color = AppColor.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Rating Row
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.rate),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                CommonTextView(
                    "4.9",
                    fontSize = 16.sp,
                    color = AppColor.Orange,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(4.dp))

                CommonTextView(
                    "(121 ratings) Cafe Western Food",
                    fontSize = 14.sp,
                    color = AppColor.placeholderBorderColour
                )
            }
        }
    }
}