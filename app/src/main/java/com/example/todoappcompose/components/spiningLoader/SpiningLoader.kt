package com.example.todoappcompose.components.spiningLoader

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun SpiningLoader(modifier: Modifier = Modifier) {

    val count = 12

    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = count.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(count * 80, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = modifier.size(48.dp)) {

        val canvasWidth = size.width
        val canvasHeight = size.height

        val width = size.width * .3f
        val height = size.height / 8

        val cornerRadius = width.coerceAtMost(height) / 2

        for (i in 0..360 step 360 / count) {
            rotate(i.toFloat()) {
                drawRoundRect(
                    color = Color.LightGray.copy(alpha = .7f),
                    topLeft = Offset(canvasWidth - width, (canvasHeight - height) / 2),
                    size = Size(width, height),
                    cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                )
            }
        }

        val coefficient = 360f / count

        for (i in 1..4) {
            rotate((angle.toInt() + i) * coefficient) {
                drawRoundRect(
                    color = Color.Gray.copy(alpha = (0.2f + 0.2f * i).coerceIn(0f, 1f)),
                    topLeft = Offset(canvasWidth - width, (canvasHeight - height) / 2),
                    size = Size(width, height),
                    cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                )
            }
        }
    }
}