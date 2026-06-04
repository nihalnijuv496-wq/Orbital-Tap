package org.nihal.orbitaltap.Screens

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
import androidx.compose.foundation.text.TextAutoSize
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
import org.nihal.orbitaltap.Theme.GlowBox
import org.nihal.orbitaltap.Theme.GlowButton
import org.nihal.orbitaltap.Theme.glowTextStyle
import org.nihal.orbitaltap.Utils.HighScoreStorage

@Composable
fun GameOverScreen(gameState: GameState, onRestart: () -> Unit, onMenuClick: () -> Unit) {

    HighScoreStorage.setHighScore(gameState.score)

    //@TODO{ Should put the family in a single folder }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(3, 10, 22))
            .padding(20.dp)
            .padding(20.dp, 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            text = "OrbitalTap",
            style = glowTextStyle(20.sp, FontWeight.Light)
        )

        Spacer(Modifier.height(10.dp))

        Column (
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        )
        {
            Text(
                text = "Time Up",
                style = glowTextStyle(20.sp, FontWeight.Light),
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                GlowBox(
                    modifier = Modifier
                        .fillMaxHeight(fraction = 0.15f)
                        .weight(1f),
                    content ={
                        Text(
                            text = "Current Score:\n${gameState.score}",
                            maxLines = 2,
                            softWrap = false,
                            autoSize = TextAutoSize.StepBased(
                                minFontSize = 12.sp,
                                maxFontSize = 16.sp,
                                stepSize = 1.sp
                            ),
                            style = glowTextStyle(15.sp, FontWeight.Light),
                            textAlign = TextAlign.Center,
                            lineHeight = 25.sp
                        )
                    }
                )



                Spacer(modifier = Modifier.width(10.dp))

                GlowBox(
                    modifier = Modifier
                        .fillMaxHeight(fraction = 0.15f)
                        .weight(1f),
                    content ={
                        Text(
                            text = "High Score:\n${HighScoreStorage.getHighScore()}",
                            maxLines = 2,
                            softWrap = false,
                            autoSize = TextAutoSize.StepBased(
                                minFontSize = 12.sp,
                                maxFontSize = 16.sp,
                                stepSize = 1.sp
                            ),
                            style = glowTextStyle(15.sp, FontWeight.Light),
                            textAlign = TextAlign.Center,
                            lineHeight = 25.sp,
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                GlowButton(
                    onClick = onMenuClick,
                    modifier = Modifier
                        .weight(1f),
                    text = "Exit"
                )

                Spacer(modifier = Modifier.width(10.dp))

                GlowButton(
                    onClick = onRestart,
                    modifier = Modifier
                        .weight(1f),
                    text = "Restart"
                )

                Spacer(modifier = Modifier.width(10.dp))

                GlowButton(
                    onClick = onMenuClick,
                    modifier = Modifier
                        .weight(1f),
                    text = "Reset"
                )
            }

        }
    }
}

