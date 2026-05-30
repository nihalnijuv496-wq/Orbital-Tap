package org.nihal.orbitaltap

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

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
                onStartGame = {
                    screen = "game"
                    gameState.startGame() },
                onExit = {
                    gameState.resetAll()
                }
            )
            "game" -> GameScreen(
                gameState = gameState,
                onExit = {
                    gameState.resetAll()
                    screen = "menu"
                }
            )
        }

        if(gameState.isGameOver)
            GameOverScreen(
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

