package org.nihal.orbitaltap

/*import androidx.compose.ui.draw.shadow as TextShadow*/
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orbitaltap.shared.generated.resources.Comfortaa_Bold
import orbitaltap.shared.generated.resources.Comfortaa_Light
import orbitaltap.shared.generated.resources.Comfortaa_Medium
import orbitaltap.shared.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.nihal.orbitaltap.Utils.Timer.StartTimer
import androidx.compose.ui.graphics.shadow.Shadow as BoxShadow

@Composable
fun GameScreen(gameState: GameState, onGameOver: () -> Unit) {
    //@TODO{ Should put the family in a single folder }
    val ComfortaaFamily = FontFamily(
        Font(Res.font.Comfortaa_Bold, FontWeight.Bold),
        Font(Res.font.Comfortaa_Light, FontWeight.Light),
        Font(Res.font.Comfortaa_Medium, FontWeight.Medium)
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(3, 10, 22))
            .padding(20.dp, 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "OrbitalTap",
            fontFamily = ComfortaaFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            color = Color(174,226,255),
            style = TextStyle(
                shadow = Shadow(
                    color = Color(174,226,255),
                    offset = Offset(x = 0f, y = 0f),
                    blurRadius = 8f
                )
            )
        )

        Spacer(Modifier.height(5.dp))

        StarMapRenderer(gameState)

        Spacer(Modifier.width(25.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Score: ${gameState.score}",
                textAlign = TextAlign.Center,
                fontFamily = ComfortaaFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(174,226,255),
                style = TextStyle(
                    shadow = Shadow(
                        color = Color(174, 226, 255),
                        offset = Offset(x = 0f, y = 0f),
                        blurRadius = 8f
                    )
                )
            )


            Spacer(Modifier.width(50.dp))

            StartTimer(gameState, onGameOver)

            Text(
                text = "Time: ${gameState.timer.remainingTimeSeconds.toInt()}",
                textAlign = TextAlign.Center,
                fontFamily = ComfortaaFamily,
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                color = Color(174,226,255),
                style = TextStyle(
                    shadow = Shadow(
                        color = Color(174,226,255),
                        offset = Offset(x = 0f, y = 0f),
                        blurRadius = 8f
                    )
                )
            )
        }


        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.70f)
            .border(width = 2.dp, color = Color(174,226,255), shape = RoundedCornerShape(10.dp))
            .dropShadow(
                shape = RoundedCornerShape(10.dp),
                shadow = BoxShadow(
                    color = Color(174, 226, 255).copy(0.4f),
                    offset = DpOffset.Zero,
                    radius = 10.dp,
                    spread = 2.dp,
                )
            )
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(3, 10, 22)),
            contentAlignment = Alignment.Center
        )

        {
            Text(
                text = gameState.currQuestion,
                fontFamily = ComfortaaFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                color = Color(174,226,255)
            )
        }


    }
}