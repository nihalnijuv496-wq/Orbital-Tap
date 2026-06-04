package org.nihal.orbitaltap.Screens

/*import androidx.compose.ui.draw.shadow as TextShadow*/
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.nihal.orbitaltap.States.GameState
import org.nihal.orbitaltap.Theme.ComfortaaFamily
import org.nihal.orbitaltap.Theme.GlowBox
import org.nihal.orbitaltap.Theme.glowTextStyle
import org.nihal.orbitaltap.Utils.StarMapRenderer
import org.nihal.orbitaltap.Utils.Timer.StartTimer

@Composable
fun GameScreen(gameState: GameState, onGameOver: () -> Unit) {

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
            style = glowTextStyle(20.sp, FontWeight.Light)
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
                style = glowTextStyle(20.sp, FontWeight.Medium),
                textAlign = TextAlign.Center
            )


            Spacer(Modifier.width(50.dp))

            StartTimer(gameState, onGameOver)

            Text(
                text = "Time: ${gameState.timer.remainingTimeSeconds.toInt()}",
                style = glowTextStyle(23.sp, FontWeight.Medium),
                textAlign = TextAlign.Center
            )
        }

        GlowBox(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.70f)

                .background(color = Color(3, 10, 22)),
            content = {
                Text(
                    text = gameState.currQuestion,
                    fontFamily = ComfortaaFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(174,226,255)
                )
            }
        )
    }
}