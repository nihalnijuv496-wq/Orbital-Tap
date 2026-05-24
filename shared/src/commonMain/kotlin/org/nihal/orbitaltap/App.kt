package org.nihal.orbitaltap

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import orbitaltap.shared.generated.resources.Res
import orbitaltap.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App()
{
    MaterialTheme {
        var gameState = remember { GameState() }
        var screen by remember { mutableStateOf("menu") }

        when(screen)
        {
            "menu" -> MenuScreen(
                onStartGame = {screen = "game"}
            )
            "game" -> GameScreen(
                gameState = gameState,
                onGameOver = {screen = "gameover"}
            )
            "gameover" -> GameOverScreen(
                gameState = gameState,
                onRestart = {
                    gameState.startGame()
                    screen = "game"
                },
                onMenuClick = {
                    gameState.resetAll()
                    screen = "menu"
                }
            )
        }
    }
}