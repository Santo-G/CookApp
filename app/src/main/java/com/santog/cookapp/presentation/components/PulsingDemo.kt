package com.santog.cookapp.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


object PulseAnimationDefinitions {
    /*
        enum class PulseState {
            INITIAL,
            FINAL
        }

        var currentState by remember { mutableStateOf(PulseState.INITIAL) }
        private val transition = updateTransition(currentState, label = "animation state")*/

    /*    val transition = transition.animateFloat(label = "animation") { state ->
            when (state) {
                PulseState.INITIAL -> 40f
                PulseState.FINAL -> 50f
            }
        }*/


    /*    val pulse by transition.animateFloat(
            transitionSpec = {
                when {
                    PulseState.INITIAL isTransitioningTo PulseState.FINAL ->
                        infiniteRepeatable(
                            animation = tween(
                                durationMillis = 500,
                                easing = FastOutSlowInEasing
                            ),
                            repeatMode = RepeatMode.Restart
                        )

                    else ->
                        tween(durationMillis = 500)
                }
            }, label = "pulseAnimation"
        ) { state ->
            when (state) {
                PulseState.INITIAL -> 40f
                PulseState.FINAL -> 50f
            }
        }*/

}

    @Composable
    fun PulsingDemo() {
        val color = MaterialTheme.colors.primary

        val infiniteTransition = rememberInfiniteTransition()
        val pulse = infiniteTransition.animateFloat(
            40f,
            50f,
            // No offset for the 1st animation
            infiniteRepeatable(tween(600), RepeatMode.Restart)
        )

        Row(
            modifier = Modifier.fillMaxWidth().height(55.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = Icons.Default.Favorite,
                contentDescription = "image",
                modifier = Modifier.align(Alignment.CenterVertically).height(pulse.value.dp).width(pulse.value.dp)
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ){
            drawCircle(
                radius = pulse.value,
                brush = SolidColor(color)
            )

        }

    }



