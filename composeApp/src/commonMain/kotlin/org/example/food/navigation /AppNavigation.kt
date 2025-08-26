package org.example.food.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.tab_home
import fooddelivery.composeapp.generated.resources.tab_menu
import fooddelivery.composeapp.generated.resources.tab_more
import fooddelivery.composeapp.generated.resources.tab_offer
import fooddelivery.composeapp.generated.resources.tab_profile
import org.example.food.CommonUI.CurvedBottomBar
import org.example.food.Model.NavBarItem
import org.example.food.UI.*
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.layout.*

@Composable
fun AppNavigation(  onOpenRestaurants: (String) -> Unit ) {
    var selected by rememberSaveable { mutableStateOf(2) } // default Home
    val navController: NavHostController = rememberNavController() // 👈 single navController

    val homeIcon: Painter = painterResource(Res.drawable.tab_home)
    val menuIcon: Painter = painterResource(Res.drawable.tab_menu)
    val offerIcon: Painter = painterResource(Res.drawable.tab_offer)
    val profileIcon: Painter = painterResource(Res.drawable.tab_profile)
    val moreIcon: Painter = painterResource(Res.drawable.tab_more)

    val items = listOf(
        NavBarItem("Menu", "Menu") { color ->
            Icon(painter = menuIcon, contentDescription = "Menu", tint = color, modifier = Modifier.size(18.dp))
        },
        NavBarItem("Offer", "Offer") { color ->
            Icon(painter = offerIcon, contentDescription = "Offer", tint = color, modifier = Modifier.size(18.dp))
        },
        NavBarItem("Home", "Home") { color ->
            Icon(painter = homeIcon, contentDescription = "Home", tint = color, modifier = Modifier.size(18.dp))
        },
        NavBarItem("Profile", "Profile") { color ->
            Icon(painter = profileIcon, contentDescription = "Profile", tint = color, modifier = Modifier.size(18.dp))
        },
        NavBarItem("More", "More") { color ->
            Icon(painter = moreIcon, contentDescription = "More", tint = color)
        }
    )

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            ) {
                CurvedBottomBar(
                    items = items,
                    selectedIndex = selected,
                    onItemSelected = { idx -> selected = idx },
                    fabRadius = 28.dp,
                    barHeight = 56.dp,
                    iconSize = 28.dp
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (items[selected].label) {
                "Home" -> HomeScreen()
                "Menu" -> MenuScreen { category ->
                    onOpenRestaurants(category)          // <— forward up
                }
                "Offer" -> OffersScreen()
                "Profile" -> ProfileScreen()
                "More" -> MoreScreen()
            }
        }
    }
}
