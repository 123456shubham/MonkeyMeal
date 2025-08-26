package org.example.food.Model

import androidx.compose.material3.contentColorFor
import androidx.compose.ui.graphics.Color
import org.example.food.ConstantVariable.FabPosition
data class FabConfiguration(
    val position: FabPosition = FabPosition.Center, // Where the FAB will be positioned
    val onClick: () -> Unit,                        // Action when the FAB is clicked
    val contentDescription: String? = null,         // Accessibility description (for TalkBack)
    val backgroundColor: Color = Color.Black,       // Background color of the FAB
//    val contentColor: Color = contentColorFor(backgroundColor) // Icon/text color based on background
)

