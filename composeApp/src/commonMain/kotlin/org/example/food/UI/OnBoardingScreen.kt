package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.on_boarding_1
import fooddelivery.composeapp.generated.resources.on_boarding_2
import fooddelivery.composeapp.generated.resources.on_boarding_3
import kotlinx.coroutines.launch
import org.example.food.Model.OnboardingPage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun OnBoardingScreen(
    onFinish: () -> Unit
) {
    val pages = listOf(
        OnboardingPage(painterResource(Res.drawable.on_boarding_1), "Find Food You Love","Discover the best food and drinks around you"),
        OnboardingPage(painterResource(Res.drawable.on_boarding_2), "Fast Delivery"," Fast Food Delivery at your doorstep"),
        OnboardingPage(painterResource(Res.drawable.on_boarding_3), "Live Tracking","Real Time Tracking of Your Order")
    )

    val pagerState = rememberPagerState(initialPage = 0) { pages.size }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip button
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            if (pagerState.currentPage < pages.lastIndex) {
                Text(
                    text = "Skip",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onFinish() }
                )
            }
        }

        // Pager with image and title
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { pageIndex ->
            val page = pages[pageIndex]
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Image(
                    painter = page.image,
                    contentDescription = null,
                    modifier = Modifier.size(300.dp)
                )


                Spacer(modifier = Modifier.height(20.dp))

                // Pager indicator
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    repeat(pages.size) { index ->
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .background(
                                    if (pagerState.currentPage == index) Color(0xFFFC6011) else Color.LightGray,
                                    shape = CircleShape
                                )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))


                Text(
                    text = page.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = page.desc,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }



        // Next / Get Started button
        Button(
            onClick = {
                if (pagerState.currentPage == pages.lastIndex) {
                    onFinish()
                } else {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFC6011), // Orange background
                contentColor = Color.White // Text color
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
        ) {
            Text(
                text = if (pagerState.currentPage == pages.lastIndex) "Get Started" else "Next"
            )
        }

    }
}




