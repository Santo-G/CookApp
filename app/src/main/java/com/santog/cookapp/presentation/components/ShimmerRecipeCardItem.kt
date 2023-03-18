package com.santog.cookapp.presentation.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun shimmerRecipeCardItem(
    cardHeight: Dp,
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit
) {
    if (isLoading) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight)
                .padding(
                    bottom = 6.dp,
                    top = 6.dp
                ),
            shape = MaterialTheme.shapes.small,
            elevation = 8.dp
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(cardHeight)
                    .shimmerEffect(),
            )
        }
    } else {
        contentAfterLoading()
    }
}

// create a custom modifier to use shimmer effect on every type of Composable object
fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5)
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}
