package com.santog.cookapp.presentation.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.santog.cookapp.R
import com.santog.cookapp.util.loadPicture


enum class HeartButtonState {
    IDLE, ACTIVE
}

@Composable
fun HeartButtonAnimation(
/*    currentTransitionState: MutableState<HeartButtonState>,
    onToggle: () -> Unit*/
) {
    val currentTransitionState = remember { mutableStateOf(HeartButtonState.IDLE) }

    val idleIconSize = 50.dp
    val expandedIconSize = 80.dp

/*    val offsetAnimation: Dp by animateDpAsState(
        if (currentTransitionState.value == HeartButtonState.IDLE) idleIconSize else expandedIconSize,
        keyframes {
            durationMillis = 500
            expandedIconSize at 100
            idleIconSize at 200
        }
    )*/

    val offsetAnimation: Dp by animateDpAsState(
        if (currentTransitionState.value == HeartButtonState.IDLE) idleIconSize else expandedIconSize,
        animationSpec = repeatable(
            iterations = 3,
            animation = tween(durationMillis = 500),
            repeatMode = RepeatMode.Restart

        )
    )


    // define the state which transition will depend on (define multiple animation based on single state)
    // var currentTransitionState = remember { mutableStateOf(HeartButtonState.IDLE) }
    // define transition that depends on the targetState value
/*    val transition = updateTransition(
        targetState = currentTransitionState,
        label = "heart transition state"
    )

    // animate different values based on transition value (color, int, dp, etc)
    val heartColor by transition
        .animateColor(label = "heart color") { state ->
        when (state.value) {
            HeartButtonState.IDLE -> Color.LightGray
            HeartButtonState.ACTIVE -> Color.Red
        }
    }

    // animate different values based on transition value (color, int, dp, etc)
    val heartSize by transition
        .animateDp(label = "heart size") { state ->
        when (state.value) {
            HeartButtonState.IDLE -> idleIconSize
            HeartButtonState.ACTIVE -> expandedIconSize
        }
    }*/

    if (currentTransitionState.value == HeartButtonState.ACTIVE) {
        loadPicture(drawable = R.drawable.heart_red).value?.let { image ->
            Image(
                bitmap = image.asImageBitmap(),
                contentDescription = "",
                modifier = Modifier
                    .clickable( onClick = {
                        currentTransitionState.value = HeartButtonState.IDLE
                    })
                    .width(offsetAnimation)
                    .height(offsetAnimation)
            )
        }
    } else {
        loadPicture(drawable = R.drawable.heart_grey).value?.let { image ->
            Image(
                bitmap = image.asImageBitmap(),
                contentDescription = "",
                modifier = Modifier
                    .clickable( onClick = {
                        currentTransitionState.value = HeartButtonState.ACTIVE
                    })
                    .width(offsetAnimation)
                    .height(offsetAnimation)
            )
        }
    }

}





