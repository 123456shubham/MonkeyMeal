package org.example.food.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.tab_home
import org.example.food.CommonUI.BottomAppBar
import org.example.food.ConstantVariable.FabPosition
import org.example.food.Model.FabConfiguration
import org.jetbrains.compose.resources.painterResource

// BottomAppBarWithFab.kt
@Composable
fun BottomAppBarWithFab(
    modifier: Modifier = Modifier,
    fabConfiguration: FabConfiguration,
    bottomAppBarContent: @Composable RowScope.() -> Unit
) {
    Box(modifier = modifier) {
        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            fabConfiguration = fabConfiguration,
            content = bottomAppBarContent
        )

        // Position the FAB
        FloatingActionButton(
            onClick = fabConfiguration.onClick,
            modifier = Modifier
                .size(56.dp)
                .align(when (fabConfiguration.position) {
                    FabPosition.Start -> Alignment.BottomStart
                    FabPosition.Center -> Alignment.BottomCenter
                    FabPosition.End -> Alignment.BottomEnd
                })
                .padding(bottom = 24.dp), // Elevate above the bar
//            backgroundColor = fabConfiguration.backgroundColor,
//            contentColor = fabConfiguration.contentColor
        ) {
//            Icon(fabConfiguration.icon, fabConfiguration.contentDescription)
            Image(painterResource(Res.drawable.tab_home),null)
        }
    }
}