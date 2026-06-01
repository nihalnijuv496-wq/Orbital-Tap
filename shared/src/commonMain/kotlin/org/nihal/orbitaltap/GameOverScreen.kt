package org.nihal.orbitaltap

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orbitaltap.shared.generated.resources.Comfortaa_Bold
import orbitaltap.shared.generated.resources.Comfortaa_Light
import orbitaltap.shared.generated.resources.Comfortaa_Medium
import orbitaltap.shared.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun GameOverScreen(gameState: GameState, onRestart: () -> Unit, onMenuClick: () -> Unit) {

    //@TODO{ Should put the family in a single folder }
    val ComfortaaFamily = FontFamily(
        Font(Res.font.Comfortaa_Bold, FontWeight.Bold),
        Font(Res.font.Comfortaa_Light, FontWeight.Light),
        Font(Res.font.Comfortaa_Medium, FontWeight.Medium)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(3, 10, 22).copy(0.7f))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text = "OrbitalTap",
            fontFamily = ComfortaaFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            color = Color.White
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "Time Up",
            fontFamily = ComfortaaFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            color = Color.White
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.15f)
                    .weight(1f)
                    .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    text = "Current Score:\n${gameState.score}",
                    fontFamily = ComfortaaFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            }


            Spacer(modifier = Modifier.width(2.dp))


            Box(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.15f)
                    .weight(1f)                    .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center

            )
            {

                Text(
                    text = "High Score:\n${gameState.score}",   //@TODO{get high score}
                    fontFamily = ComfortaaFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            }




        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Button(
                onClick = onMenuClick,
                modifier = Modifier
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                border = BorderStroke(width = 2.dp, color = Color.White),
                shape = RectangleShape

            )
            {
                Text(
                    text = "Exit",
                    style = TextStyle(
                        fontFamily = ComfortaaFamily,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.width(2.dp))

            Button(
                onClick = onRestart,
                modifier = Modifier
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                border = BorderStroke(width = 2.dp, color = Color.White),
                shape = RectangleShape

            )
            {
                Text(
                    text = "Restart",
                    style = TextStyle(
                        fontFamily = ComfortaaFamily,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White
                    )
                )
            }
        }
    }
}

