package org.example.food.UI

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.add
import fooddelivery.composeapp.generated.resources.cat_3
import fooddelivery.composeapp.generated.resources.minus
import org.example.food.CommonUI.CommonTextView
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun CartItemScreen(){
    CartItemRow("Pizza", 10,1)
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CartItemRow(
    name: String,
    price: Int,
    initialQuantity: Int = 1,
    onQuantityChanged: (Int) -> Unit = {}
) {
    var quantity by remember { mutableStateOf(initialQuantity) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Item Name
        CommonTextView(
            text = name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.weight(3f)
        )

        // Quantity controls
        Row(
            modifier = Modifier
                .height(35.dp)
                .background(Color(0xFFEAEAEA)) // replace with shape if you want
                .padding(horizontal = 15.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Decrement button
            Image(
                painter = painterResource(Res.drawable.minus),
                contentDescription = "Decrease",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        if (quantity > 1) {
                            quantity--
                            onQuantityChanged(quantity)
                        }
                    }
            )

            // Quantity text
            CommonTextView(
                text = quantity.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .width(50.dp)
                    .wrapContentHeight()
                    .padding(horizontal = 5.dp),
            )

            // Increment button
            Image(
                painter = painterResource(Res.drawable.add),
                contentDescription = "Increase",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        quantity++
                        onQuantityChanged(quantity)
                    }
            )
        }

        // Price
        CommonTextView(
            text = (price * quantity).toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .width(50.dp)
                .padding(start = 10.dp),
        )
    }
}
