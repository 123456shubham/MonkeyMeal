package org.example.food.ConstantVariable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.tab_home
import fooddelivery.composeapp.generated.resources.tab_menu
import fooddelivery.composeapp.generated.resources.tab_offer
import fooddelivery.composeapp.generated.resources.tab_profile
import org.jetbrains.compose.resources.painterResource


enum class BottomTabs(
    val label: String,
    val icon: @Composable () -> Unit
) {
    Home("Home", { Image(painterResource(Res.drawable.tab_home), contentDescription = null) }),
    Menu("Menu", { Image(painterResource(Res.drawable.tab_menu), contentDescription = null) }),
    Offer("Offer", { Image(painterResource(Res.drawable.tab_offer), contentDescription = null) }),
    Profile("Profile", { Image(painterResource(Res.drawable.tab_profile), contentDescription = null) })

}