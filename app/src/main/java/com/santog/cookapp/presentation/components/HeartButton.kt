package com.santog.cookapp.presentation.components
import androidx.compose.animation.*
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp


private enum class HeartButtonState {
    IDLE, ACTIVE
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeartButton() {
    var state by remember { mutableStateOf(HeartButtonState.IDLE) }
    val iconSize = 100.dp
    val overshootFactor = 1.3f
    val animationDurationMs = 500

    Box(
        modifier = Modifier.size(iconSize * overshootFactor),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = state,
            transitionSpec = {
                    fadeIn(
                        animationSpec = tween(
                            durationMillis = animationDurationMs / 2,
                            easing = EaseInOutCubic
                        )
                    ) + scaleIn(
                        animationSpec = keyframes {
                            durationMillis = animationDurationMs
                            1f at 0 with EaseInOutCubic
                            overshootFactor at animationDurationMs / 2 with EaseInOutCubic
                            1f at animationDurationMs with EaseInOutCubic
                        }
                    ) with fadeOut() using SizeTransform(clip = false)
            }
        ) { targetState ->
            when (targetState) {
                HeartButtonState.IDLE -> Image(
                    modifier = Modifier
                        .size(iconSize)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            state = HeartButtonState.ACTIVE
                        },
                    painter = rememberVectorPainter(image = Icons.Filled.Favorite),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
                HeartButtonState.ACTIVE -> Image(
                    modifier = Modifier
                        .size(iconSize)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            state = HeartButtonState.IDLE
                        },
                    painter = rememberVectorPainter(image = Icons.Filled.Favorite),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Red)
                )
            }
        }
    }
}


