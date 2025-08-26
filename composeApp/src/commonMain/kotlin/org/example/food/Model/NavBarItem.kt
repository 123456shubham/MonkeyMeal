package org.example.food.Model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class NavBarItem(
    val id: String,
    val label: String,
    val icon: @Composable (Color) -> Unit // icon takes tint color
)