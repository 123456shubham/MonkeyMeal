package org.example.food.CommonUI


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.app_logo
import fooddelivery.composeapp.generated.resources.btn_back
import fooddelivery.composeapp.generated.resources.check
import org.example.food.theme.AppColor
import org.jetbrains.compose.resources.painterResource

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import org.example.food.ConstantVariable.FabPosition
import org.example.food.Model.FabConfiguration
import org.example.food.Model.NavBarItem

// common Image function for loading SVG File and GIF file
//@Composable
//fun CommonImage(
//    imageUrl: String,
//    contentDescription: String? = null,
//    modifier: Modifier = Modifier
//        .fillMaxWidth()
//        .height(160.dp)
//        .clip(RoundedCornerShape(8.dp)),
//    contentScale: ContentScale = ContentScale.Crop
//) {
//    val context = LocalContext.current
//
//    LaunchedEffect(imageUrl) {
//        Log.d("CommonImage", "Loading image URL: $imageUrl")
//    }
//
//    Image(
//        painter = rememberAsyncImagePainter(
//            model = ImageRequest.Builder(context)
//                .data(imageUrl)
//                .crossfade(true)
//                .placeholder(R.drawable.spinner)
//                .error(R.drawable.spinner)
//                .build()
//        ),
//        contentDescription = contentDescription,
//        modifier = modifier,
//        contentScale = contentScale
//    )
//}


fun openCamera(){

}

fun openGallery(){

}

fun openPDF(){

}



fun isValidMobileNumber(number: String): Boolean {
    return number.length == 10 && number.all { it.isDigit() }
}


fun isValidOTP(otp: String): Boolean {
    return otp.length==4 && otp.all { it.isDigit() }
}

// common Text View & storing dynamic value
@Composable
fun CommonTextView(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    paddingStart: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    fontFamily: FontFamily = FontFamily.Default,
    style: TextStyle = TextStyle.Default // optional full style override
) {
    Text(
        text = text,
        modifier = modifier.padding(
            start = paddingStart,
            end = paddingEnd,
            top = paddingTop,
            bottom = paddingBottom
        ),
        textAlign = textAlign,

        style = style.merge(
            TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight,
                fontFamily = fontFamily,
                color = color,
            )
        ),
        maxLines = maxLines,
        overflow = overflow
    )
}


@Composable
fun MyOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Enter text...",
    textColor: Color = Color.Black,
    placeholderColor: Color = Color.Gray,
    borderColor: Color = Color.Black,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    paddingStart: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    borderRadius: Int = 30,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(
                start = paddingStart,
                end = paddingEnd,
                top = paddingTop,
                bottom = paddingBottom
            )
            .fillMaxWidth(),
        textStyle = TextStyle(
            color = textColor,
            fontSize = 16.sp
        ),
        placeholder = {
            Text(text = placeholder, color = placeholderColor)
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        singleLine = true,
        shape = RoundedCornerShape(borderRadius.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = borderColor,
            unfocusedIndicatorColor = borderColor,
            cursorColor = borderColor,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
}



@Composable
fun AppButton(
    title: String,
    paddingStart: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    textColor: Color = Color.White,
    background: Color = Color.Transparent, // Default background color
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(30.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp), // Updated for Material3
        colors = ButtonDefaults.buttonColors(
            containerColor = background // Updated from backgroundColor
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = paddingStart,
                end = paddingEnd,
                top = paddingTop,
                bottom = paddingBottom
            )
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                color = textColor,
                fontWeight = FontWeight.W600
            )
        )
    }
}

@Composable
fun CartButton(
    title: String,
    paddingStart: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    textColor: Color = Color.White,
    background: Color = Color.Blue, // Default background color
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(0.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp), // Updated for Material3
        colors = ButtonDefaults.buttonColors(
            containerColor = background // Updated from backgroundColor
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = paddingStart,
                end = paddingEnd,
                top = paddingTop,
                bottom = paddingBottom
            )
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                color = textColor,
                fontWeight = FontWeight.W600
            )
        )
    }
}

@Composable
fun SpacerHeight(height: Dp = 5.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(width: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(width))
}


const val OTP_VIEW_TYPE_NONE = 0
const val OTP_VIEW_TYPE_UNDERLINE = 1
const val OTP_VIEW_TYPE_BORDER = 2



@Composable
fun OtpView(
    modifier: Modifier = Modifier,
    otpText: String = "",
    charColor: Color = Color(0XFFE8E8E8),
    charBackground: Color = Color.Transparent,
    charSize: TextUnit = 20.sp,
    containerSize: Dp = charSize.value.dp * 2,
    otpCount: Int = 4,
    type: Int = OTP_VIEW_TYPE_BORDER,
    enabled: Boolean = true,
    password: Boolean = false,
    passwordChar: String = "*",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
    onOtpTextChange: (String) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = {
            if (it.length <= otpCount) {
                onOtpTextChange.invoke(it)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center),
        decorationBox = { innerTextField ->
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(otpCount) { index ->
                    Spacer(modifier = Modifier.width(2.dp))
                    CharView(
                        index = index,
                        text = otpText,
                        charColor = charColor,
                        charSize = charSize,
                        containerSize = containerSize,
                        type = type,
                        charBackground = charBackground,
                        password = password,
                        passwordChar = passwordChar,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    charColor: Color,
    charSize: TextUnit,
    containerSize: Dp,
    type: Int = OTP_VIEW_TYPE_UNDERLINE,
    charBackground: Color = Color.Transparent,
    password: Boolean = false,
    passwordChar: String = "*"
) {
    val char = when {
        index >= text.length -> ""
        password -> passwordChar
        else -> text[index].toString()
    }

    val boxModifier = if (type == OTP_VIEW_TYPE_BORDER) {
        Modifier
            .size(containerSize)
            .border(
                width = 1.dp,
                color = charColor,
                shape = RoundedCornerShape(5.dp)
            )
            .background(charBackground)
    } else Modifier
        .width(containerSize)
        .background(charBackground)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = char,
            color = Color.Black,
            fontSize = charSize,
            textAlign = TextAlign.Center,
            modifier = boxModifier
                .wrapContentHeight()
                .padding(4.dp)
        )

        if (type == OTP_VIEW_TYPE_UNDERLINE) {
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .background(charColor)
                    .height(1.dp)
                    .width(containerSize)
            )
        }
    }
}



@Composable
fun DynamicTextViews(x: Int,modifier: Modifier) {
    // Create a list of Text views based on the value of x
    Row {
        repeat(x) { index ->
            Text(text = "in",modifier.background(Color.White))
        }
    }
}


@Composable
fun DynamicSelectableImages(total: Int, selectedCount: Int) {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(total) { index ->
            val isSelected = index < selectedCount
            Image(
                painter = painterResource(Res.drawable.check), // Replace with your image resource
                contentDescription = "Image $index",
                modifier = Modifier
                    .size(15.dp)
                    .background(if (isSelected) Color.Green else Color.White, shape = CircleShape)
                    .padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    title: String = "My App",
    onBackClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = title, color = AppColor.Orange)
        },
        navigationIcon = {
            if (onBackClick != null) {
                Icon(
                    painter = painterResource(Res.drawable.btn_back),
                    contentDescription = "Back",
                    tint = AppColor.Orange,
                    modifier = Modifier
                        .clickable(onClick = onBackClick)
                        .padding(16.dp)
                        .size(24.dp)

                )
            }
        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = AppColors.Orange
//        )
    )
}


@Composable
fun GenderRadioGroup(
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {
    val options = listOf("Male", "Female")

    Row(modifier = Modifier.padding(start =10.dp)) {
        options.forEach { gender ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = selectedGender == gender,
                    onClick = { onGenderSelected(gender) }
                )
                Text(
                    text = gender,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}


@Composable
fun BottomAppBar(
    modifier: Modifier = Modifier,
    fabConfiguration: FabConfiguration? = null,
    containerColor: Color =Color.White,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = 8.dp,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        color = containerColor,
        contentColor = contentColor,
//        elevation = tonalElevation,
        modifier = modifier
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            // Draw the notch if FAB is present
            if (fabConfiguration != null) {
                BottomAppBarNotch(fabConfiguration.position)
            }

            // Content row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp) // Increased height to accommodate notch
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}

@Composable
private fun BottomAppBarNotch(position: FabPosition) {
    val fabWidth = 56.dp
    val fabHeight = 56.dp
    val notchHeight = 16.dp

    Canvas(modifier = Modifier.fillMaxWidth().height(notchHeight)) {
        val path = Path().apply {
            val horizontalPosition = when (position) {
                FabPosition.Start -> fabWidth / 2
                FabPosition.Center -> size.width / 2
//                FabPosition.End -> size.width - fabWidth / 2
                else -> {}
            }

            moveTo(0f, size.height)
//            lineTo(horizontalPosition - fabWidth.toPx() * 0.6f, size.height)

            // Notch curve
            quadraticBezierTo(
                horizontalPosition as Float,
                -notchHeight.toPx() * 0.5f,
                horizontalPosition + fabWidth.toPx() * 0.6f,
                size.height
            )

            lineTo(size.width, size.height)
            lineTo(size.width, 0f)
            lineTo(0f, 0f)
            close()
        }

        drawPath(
            path = path,
            color =Color.Black,
            style = Fill
        )
    }
}



/**
 * Curved bottom bar that draws a notch (cubic curves) centered for a FAB.
 * - items: list of nav items (if odd count, middle space will be the FAB gap)
 * - fabRadius: radius of the FAB in dp (default matches typical 56.dp FAB -> radius 28.dp)
 */

@Composable
fun CurvedBottomBar(
    items: List<NavBarItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    fabRadius: Dp,
    barHeight: Dp,
    iconSize: Dp = 40.dp,       // bigger for visibility
    selectedMargin: Dp = 1.dp,
    bottomMargin: Dp = 0.dp,
) {
    val animatedIndex by animateFloatAsState(
        targetValue = selectedIndex.toFloat(),
        animationSpec = tween(durationMillis = 350, easing = FastOutSlowInEasing),
        label = ""
    )

    val density = LocalDensity.current
    var curveDepthDp by remember { mutableStateOf(0.dp) }
    var itemWidthPx by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(barHeight),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Draw background with curve
        Canvas(
            modifier = Modifier
                .matchParentSize()
                .align(Alignment.BottomCenter)
        ) {
            itemWidthPx = size.width / items.size
            val curveCenterX = (animatedIndex + 0.5f) * itemWidthPx

            val iconPx = iconSize.toPx() + selectedMargin.toPx() * 2
            val curveWidth = iconPx * 1.4f
            val curveDepth = iconPx * 0.7f

            curveDepthDp = with(density) { curveDepth.toDp() }

            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(curveCenterX - curveWidth / 2, 0f)

                cubicTo(
                    curveCenterX - curveWidth / 4, 0f,
                    curveCenterX - curveWidth / 4, curveDepth,
                    curveCenterX, curveDepth
                )
                cubicTo(
                    curveCenterX + curveWidth / 4, curveDepth,
                    curveCenterX + curveWidth / 4, 0f,
                    curveCenterX + curveWidth / 2, 0f
                )

                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }

            drawPath(path, color = Color.White)
        }

        // Bottom bar items
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex
                val iconColor = if (isSelected) Color(0xFFFF9800) else Color.Gray

                Box(
                    modifier = Modifier
                        .width(with(density) { itemWidthPx.toDp() }) // ensures equal spacing
                        .clickable { onItemSelected(index) },
                    contentAlignment = Alignment.BottomCenter
                ) {
                    if (isSelected) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White,
                            shadowElevation = 6.dp,
                            modifier = Modifier
                                .offset(y = -curveDepthDp / 2) // ✅ centers icon in curve
                                .size(iconSize)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                item.icon(iconColor)
                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .padding(bottom = bottomMargin)
                                .size(iconSize),
                            contentAlignment = Alignment.Center
                        ) {
                            item.icon(iconColor)
                        }
                    }
                }
            }
        }
    }
}





//@Composable
//fun CommonTabLayout(
//    tabs: List<String>,
//    screens: List<@Composable () -> Unit>,
//    selectedTabIndex: Int, // Externally controlled tab index
//    onTabSelected: (Int) -> Unit // Callback to update tab index
//) {
//    Column(modifier = Modifier.fillMaxWidth()) {
//        // TabRow with dynamic tabs
//        TabRow(
//            selectedTabIndex = selectedTabIndex,
//            containerColor = colorResource(id = R.color.dark_pink),
//            indicator = { tabPositions ->
//                TabRowDefaults.Indicator(
//                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
//                    color = Color.White
//                )
//            },
//            divider = { Divider(color = Color.White) }
//        ) {
//            tabs.forEachIndexed { index, title ->
//                Tab(
//                    text = {
//                        Text(
//                            title,
//                            style = TextStyle(
//                                color = if (selectedTabIndex == index) Color.White else Color.LightGray,
//                                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
//                            )
//                        )
//                    },
//                    selected = selectedTabIndex == index,
//                    onClick = { onTabSelected(index) }, // Calls parent function to update state
//                )
//            }
//        }
//
//        // Display the corresponding screen dynamically
//        Box(modifier = Modifier.fillMaxSize().padding(top = 8.dp)) {
//            screens[selectedTabIndex]() // Renders the selected tab's content
//        }
//    }
//}


//@Composable
//fun SetStatusBarColor(color: Color, darkIcons: Boolean = false) {
//    val systemUiController = rememberSystemUiController()
//    SideEffect {
//        systemUiController.setStatusBarColor(
//            color = color,
//            darkIcons = darkIcons
//        )
//    }
//}



//@Composable
//fun Search(
//    text: String,
//    modifier: Modifier = Modifier,
//    onValueChange: (String) -> Unit
//) {
//    TextField(
//        value = text,
//        onValueChange = onValueChange,
//        placeholder = {
//            Text(
//                text = "Search",
//                style = TextStyle(
//                    fontWeight = FontWeight.W400,
//                    fontSize = 16.sp,
//                    fontFamily = FontFamily.Default,
//                    color = Color.LightGray
//                )
//            )
//        },
//        shape = RoundedCornerShape(8.dp),
//        leadingIcon = {
//            Icon(
//                imageVector = Icons.Filled.Search,
//                contentDescription = "search",
//                tint = Color.LightGray
//            )
//        },
//        modifier = modifier
//            .fillMaxWidth()
//            .background(colorResource(R.color.dark_pink))
//            .padding(vertical = 16.dp, horizontal = 20.dp)
//            .border(1.dp, Color.White, RoundedCornerShape(8.dp)),
//        colors = TextFieldDefaults.colors(
//            focusedContainerColor = Color.White,
//            unfocusedContainerColor = Color.White,
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        )
//    )
//}