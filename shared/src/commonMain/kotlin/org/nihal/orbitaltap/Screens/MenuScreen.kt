package org.nihal.orbitaltap.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import orbitaltap.shared.generated.resources.OrionSky_SimonGodfrey
import orbitaltap.shared.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import org.nihal.orbitaltap.Theme.GlowButton
import org.nihal.orbitaltap.Theme.glowTextStyle


@Composable
fun MenuScreen (onStartGame: () -> Unit, onExit: () -> Unit)
{

    Column (
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(
                Res.drawable.OrionSky_SimonGodfrey),
                contentScale = ContentScale.Crop),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {

        Text(
            text = "OrbitalTap",
            style = glowTextStyle(30.sp, FontWeight.Medium)
        )
        Spacer(Modifier.height(30.dp))

        GlowButton(
            text = "Start",
            onClick = onStartGame,
            modifier = Modifier
                .fillMaxWidth(fraction = 0.4f),
            showGlow = false
        )
    }
}