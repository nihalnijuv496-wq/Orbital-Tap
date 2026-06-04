package org.nihal.orbitaltap.Theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orbitaltap.shared.generated.resources.Comfortaa_Bold
import orbitaltap.shared.generated.resources.Comfortaa_Light
import orbitaltap.shared.generated.resources.Comfortaa_Medium
import orbitaltap.shared.generated.resources.Res
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.graphics.shadow.Shadow as BoxShadow


val SkyBlue = Color(174, 226, 255)
val SkyBackground = Color(3, 10, 22)

val ComfortaaFamily @Composable get() = FontFamily(
    Font(Res.font.Comfortaa_Bold, FontWeight.Bold),
    Font(Res.font.Comfortaa_Light, FontWeight.Light),
    Font(Res.font.Comfortaa_Medium, FontWeight.Medium)
)

@Composable
fun glowTextStyle(size: TextUnit, weight: FontWeight = FontWeight.Light) = TextStyle(
    fontFamily = ComfortaaFamily,
    fontSize = size,
    fontWeight = weight,
    color = SkyBlue,
    shadow = Shadow(
        color = SkyBlue,
        offset = Offset(0f, 0f),
        blurRadius = 8f
    )
)

@Composable
fun GlowBox(modifier: Modifier, content: @Composable (BoxScope.() -> Unit)) {
    Box(
        modifier = modifier
            .dropShadow(
                shape = RoundedCornerShape(10.dp),
                shadow = BoxShadow(
                    color = SkyBlue.copy(0.4f),
                    offset = DpOffset.Zero,
                    radius = 10.dp,
                    spread = 2.dp
                )
            )
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, SkyBlue, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center,
        content = content
    )
}

@Composable
fun GlowButton(text:String, onClick: () -> Unit, modifier: Modifier, showGlow: Boolean = true) {
    Button(
        onClick = onClick,
        modifier = if(showGlow)
            modifier.dropShadow(
                shape = RectangleShape,
                shadow = BoxShadow(
                    color = Color(174, 226, 255).copy(0.4f),
                    offset = DpOffset.Zero,
                    radius = 10.dp,
                    spread = 0.dp,
                )
            ) else modifier,
    colors = ButtonDefaults.buttonColors(
        containerColor = if(showGlow) Color(3, 10, 22) else Color.Transparent,
        contentColor = Color.White
    ),
    border = BorderStroke(2.dp, SkyBlue),
    shape = RectangleShape,
    )
    {
        Text(
            text = text,
            maxLines = 1,
            softWrap = false,
            autoSize = TextAutoSize.StepBased(
                minFontSize = 10.sp,
                maxFontSize = 17.sp,
                stepSize = 1.sp
            ),
            style = glowTextStyle(17.sp, FontWeight.Light)
        )
    }
}